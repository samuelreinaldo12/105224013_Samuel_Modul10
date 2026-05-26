class Transaksi {
    String namaPemesan;
    String judulFilm;
    String kursi;
    int harga;

    public Transaksi(String namaPemesan, String judulFilm, String kursi, int harga) {
        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.kursi = kursi;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return "Nama: " + namaPemesan + " | Film: " + judulFilm + " | Kursi: " + kursi + " | Harga: Rp" + harga;
    }
}