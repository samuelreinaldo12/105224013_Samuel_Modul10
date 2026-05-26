import java.util.*;
class Buku {
    String isbn;
    String judul;

    public Buku(String isbn, String judul){
        this.isbn = isbn;
        this.judul = judul;
    }

    @Override
    public String toString() {
        return "Buku[ISBN=" + isbn + ", judul=" + judul + "]";
    }
}