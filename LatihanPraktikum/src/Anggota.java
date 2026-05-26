import java.util.*;
class Anggota {
    String idAnggota;
    String nama;
    String tipe;

    public Anggota(String idAnggota, String nama, String tipe){
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.tipe = tipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anggota anggota = (Anggota) o;
        return Objects.equals(idAnggota, anggota.idAnggota); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnggota);
    }

    @Override
    public String toString() {
        return nama + " (" + tipe + " - " + idAnggota + ")";
    }
}