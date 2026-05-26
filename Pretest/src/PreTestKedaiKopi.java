import java.util.*;

public class PreTestKedaiKopi {
    public static void main(String[] args) {
        
        // TODO 1: Struktur data untuk menyimpan Antrean pelanggan.
        Queue<String> antrean = new LinkedList<>(); 
        
        // TODO 2: Struktur data untuk menyimpan Nomor Meja yang sedang dipakai.
        Set<Integer> mejaTerisi = new HashSet<>();

        // TODO 3: Struktur data untuk menyimpan Daftar Harga Menu.
        Map<String, Integer> hargaMenu = new HashMap<>();

        // --- SIMULASI (TIDAK PERLU DIUBAH) ---
        antrean.add("Budi");
        antrean.add("Siti");

        mejaTerisi.add(4);
        mejaTerisi.add(7);
        mejaTerisi.add(4); // Harus otomatis ditolak oleh sistem tanpa error

        hargaMenu.put("Kopi", 15000);
        hargaMenu.put("Teh", 10000);

        System.out.println("Daftar Antrean  : " + antrean);
        System.out.println("Meja Terisi     : " + mejaTerisi); 
        System.out.println("Harga Kopi      : Rp " + hargaMenu.get("Kopi"));
    }
}