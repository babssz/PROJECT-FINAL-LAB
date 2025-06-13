package projectFinal;

public abstract class Properti {

    protected String idProperti;
    protected String alamat;
    protected String kota;
    protected long harga;
    protected int luasBangunan;
    protected int luasTanah;
    protected int jumlahKamarTidur;
    protected int jumlahKamarMandi;
    protected String urlGambar;

    public Properti(String idProperti, String alamat, String kota, long harga,
            int luasBangunan, int luasTanah, int jumlahKamarTidur,
            int jumlahKamarMandi, String urlGambar) {
        this.idProperti = idProperti;
        this.alamat = alamat;
        this.kota = kota;
        this.harga = harga;
        this.luasBangunan = luasBangunan;
        this.luasTanah = luasTanah;
        this.jumlahKamarTidur = jumlahKamarTidur;
        this.jumlahKamarMandi = jumlahKamarMandi;
        this.urlGambar = urlGambar;
    }

    public abstract void tampilkanInfoLengkap();

    
    public String getIdProperti() {
        return idProperti;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getKota() {
        return kota;
    }

    public long getHarga() {
        return harga;
    }

    public int getLuasBangunan() {
        return luasBangunan;
    }

    public int getLuasTanah() {
        return luasTanah;
    }

    public int getJumlahKamarTidur() {
        return jumlahKamarTidur;
    }

    public int getJumlahKamarMandi() {
        return jumlahKamarMandi;
    }

    public String getUrlGambar() {
        return urlGambar;
    }
}
