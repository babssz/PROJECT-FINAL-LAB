package projectFinal;

import java.text.NumberFormat;
import java.util.Locale;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class DetailViewController {

    @FXML
    private ImageView detailImageView;

    @FXML
    private Label alamatLabel;

    @FXML
    private Label hargaLabel;

    @FXML
    private Label spesifikasiLabel;

    @FXML
    private Label agenLabel;

    @FXML
    private Button kembaliButton;

    public void initData(Properti properti) {
        try {
            Image image = new Image(getClass().getResourceAsStream(properti.getUrlGambar()));
            detailImageView.setImage(image);
        } catch (Exception e) {
            detailImageView.setImage(null);
        }

        alamatLabel.setText(properti.getAlamat());

        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        hargaLabel.setText(currencyFormat.format(properti.getHarga()));

        String spesifikasi = String.format("Luas Tanah: %d m², Luas Bangunan: %d m²\nKamar Tidur: %d, Kamar Mandi: %d",
                properti.getLuasTanah(),
                properti.getLuasBangunan(),
                properti.getJumlahKamarTidur(),
                properti.getJumlahKamarMandi());
        spesifikasiLabel.setText(spesifikasi);

        if (properti instanceof PropertiRiil) {
            PropertiRiil propertiRiil = (PropertiRiil) properti;
            agenLabel.setText("Agen: " + propertiRiil.getNamaAgen() + " (" + propertiRiil.getNomorTeleponAgen() + ")");
        } else {
            agenLabel.setText("Info agen tidak tersedia.");
        }
    }

    @FXML
    private void handleKembaliButton() {
        Stage stage = (Stage) kembaliButton.getScene().getWindow();
        stage.close();
    }
}