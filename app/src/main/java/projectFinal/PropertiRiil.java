package projectFinal;

public class PropertiRiil extends Properti {

    private String namaAgen;
    private String nomorTeleponAgen;

    public PropertiRiil(String idProperti, String alamat, String kota, long harga,
            int luasBangunan, int luasTanah, int jumlahKamarTidur,
            int jumlahKamarMandi, String urlGambar,
            String namaAgen, String nomorTeleponAgen) {

        super(idProperti, alamat, kota, harga, luasBangunan, luasTanah,
                jumlahKamarTidur, jumlahKamarMandi, urlGambar);

        this.namaAgen = namaAgen;
        this.nomorTeleponAgen = nomorTeleponAgen;
    }

    @Override
    public void tampilkanInfoLengkap() {
        System.out.println("--- Detail Properti Riil ---");
        System.out.println("Alamat: " + getAlamat() + ", " + getKota());
        System.out.println("Harga: Rp " + getHarga());
        System.out.println("Hubungi Agen: " + this.namaAgen + " (" + this.nomorTeleponAgen + ")");
    }

    public String getNamaAgen() {
        return namaAgen;
    }

    public String getNomorTeleponAgen() {
        return nomorTeleponAgen;
    }
}