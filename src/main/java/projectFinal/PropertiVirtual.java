package projectFinal; 


public class PropertiVirtual extends Properti {

    private long nilaiSewaBulanan;
    private boolean statusMilik;

    public PropertiVirtual(String idProperti, String alamat, String kota, long harga,
                           int luasBangunan, int luasTanah, int jumlahKamarTidur,
                           int jumlahKamarMandi, String urlGambar,
                           long nilaiSewaBulanan) {

        super(idProperti, alamat, kota, harga, luasBangunan, luasTanah,
              jumlahKamarTidur, jumlahKamarMandi, urlGambar);

        this.nilaiSewaBulanan = nilaiSewaBulanan;
        this.statusMilik = false;
    }

    @Override
    public void tampilkanInfoLengkap() {
        System.out.println("--- Detail Properti Virtual (Simulasi) ---");
        System.out.println("Lokasi: " + getAlamat());
        System.out.println("Harga Beli Virtual: Rp " + getHarga());
        System.out.println("Potensi Pendapatan Sewa: Rp " + this.nilaiSewaBulanan + " / bulan");
        System.out.println("Status Kepemilikan: " + (this.statusMilik ? "Dimiliki" : "Tersedia untuk dibeli"));
    }

    public long getNilaiSewaBulanan() {
        return nilaiSewaBulanan;
    }

    public boolean isStatusMilik() {
        return statusMilik;
    }

    public void setStatusMilik(boolean statusMilik) {
        this.statusMilik = statusMilik;
    }
}