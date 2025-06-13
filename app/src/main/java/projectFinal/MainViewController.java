package projectFinal;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainViewController implements Initializable {

    @FXML
    private ComboBox<String> lokasiFilter;
    @FXML
    private TextField hargaMinFilter;
    @FXML
    private TextField hargaMaxFilter;
    @FXML
    private Button terapkanFilterButton;
    @FXML
    private TableView<Properti> propertiTableView;
    @FXML
    private TableColumn<Properti, String> kolomGambar;
    @FXML
    private TableColumn<Properti, String> kolomAlamat;
    @FXML
    private TableColumn<Properti, Long> kolomHarga;
    @FXML
    private TableColumn<Properti, String> kolomSpesifikasi;

    private List<Properti> masterPropertiList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        masterPropertiList = Database.getPropertiRiilList();

        setupTableColumns();
        setupTableSelectionListener();
        setupFilterControls();

        propertiTableView.getItems().setAll(masterPropertiList);
    }

    private void setupTableSelectionListener() {
        propertiTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                showPropertiDetail(newSelection);
            }
        });
    }

    private void showPropertiDetail(Properti properti) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetailView.fxml"));
            Parent root = loader.load();

            DetailViewController controller = loader.getController();
            controller.initData(properti);

            Stage detailStage = new Stage();
            detailStage.setTitle("Detail Properti");
            detailStage.setScene(new Scene(root));
            detailStage.initModality(Modality.APPLICATION_MODAL);
            detailStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Gagal membuka halaman detail.");
        }
    }

    private void setupFilterControls() {
        List<String> lokasiList = masterPropertiList.stream()
                .map(Properti::getKota)
                .distinct()
                .collect(Collectors.toList());
        lokasiFilter.setItems(FXCollections.observableArrayList(lokasiList));
        lokasiFilter.getItems().add(0, "Semua Lokasi");
        lokasiFilter.getSelectionModel().selectFirst();

        terapkanFilterButton.setOnAction(event -> handleFilterButtonAction());
    }

    @FXML
    private void handleFilterButtonAction() {
        String lokasi = lokasiFilter.getValue();
        long hargaMin = 0;
        long hargaMax = Long.MAX_VALUE;

        try {
            if (!hargaMinFilter.getText().isEmpty()) {
                hargaMin = Long.parseLong(hargaMinFilter.getText());
            }
            if (!hargaMaxFilter.getText().isEmpty()) {
                hargaMax = Long.parseLong(hargaMaxFilter.getText());
            }
        } catch (NumberFormatException e) {
            showAlert("Input Salah", "Harap masukkan angka yang valid untuk harga.");
            return;
        }

        long finalHargaMin = hargaMin;
        long finalHargaMax = hargaMax;

        List<Properti> filteredList = masterPropertiList.stream()
                .filter(p -> {
                    boolean lokasiMatch = "Semua Lokasi".equals(lokasi) || p.getKota().equals(lokasi);
                    boolean hargaMatch = p.getHarga() >= finalHargaMin && p.getHarga() <= finalHargaMax;
                    return lokasiMatch && hargaMatch;
                })
                .collect(Collectors.toList());

        propertiTableView.getItems().setAll(filteredList);
    }

    private void setupTableColumns() {
        kolomAlamat.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAlamat()));
        kolomHarga.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getHarga()));

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        kolomHarga.setCellFactory(tc -> new TableCell<Properti, Long>() {
            @Override
            protected void updateItem(Long price, boolean empty) {
                super.updateItem(price, empty);
                setText(empty ? null : currencyFormat.format(price));
            }
        });

        kolomSpesifikasi.setCellValueFactory(cellData -> {
            Properti p = cellData.getValue();
            String s = String.format("LT: %d m², LB: %d m²\nKT: %d, KM: %d",
                    p.getLuasTanah(), p.getLuasBangunan(), p.getJumlahKamarTidur(), p.getJumlahKamarMandi());
            return new SimpleStringProperty(s);
        });

        kolomGambar.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUrlGambar()));
        kolomGambar.setCellFactory(param -> new TableCell<Properti, String>() {
            private final ImageView imageView = new ImageView();

            @Override
            protected void updateItem(String path, boolean empty) {
                super.updateItem(path, empty);
                if (empty || path == null || path.isEmpty()) {
                    setGraphic(null);
                } else {
                    try {
                        Image image = new Image(getClass().getResourceAsStream(path));
                        imageView.setImage(image);
                        imageView.setFitWidth(130);
                        imageView.setPreserveRatio(true);
                        setGraphic(imageView);
                    } catch (Exception e) {
                        setGraphic(null);
                    }
                }
            }
        });
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}