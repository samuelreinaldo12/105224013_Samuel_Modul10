import java.util.*;
public class SistemPerpustakaan {
    public static void main(String[] args) {
        
        System.out.println("    KATALOG BUKU    ");
        Map<String, Buku> katalogBuku = new HashMap<>();
        
        katalogBuku.put("1208-A12", new Buku("1208-A12", "Pada Zaman Dahulu"));
        katalogBuku.put("1208-B12", new Buku("1208-B12", "Upin Ipin"));
        katalogBuku.put("1208-C12", new Buku("1208-C12", "Boboiboy"));
        
        System.out.println("Katalog berhasil dibuat.");

        System.out.println("    DAFTAR ANGGOTA    ");
        Set<Anggota> daftarAnggota = new HashSet<>();
        
        daftarAnggota.add(new Anggota("A0012", "Vania", "Pengangguran"));
        daftarAnggota.add(new Anggota("A0022", "Felita", "Calon Dokter"));
        daftarAnggota.add(new Anggota("D0013", "Aldo", "Mahasiswa"));
        
        System.out.println("Daftar anggota berhasil dibuat.");

        System.out.println("    ANTREAN PEMINJAMAN    ");
        Deque<String> antrean = new LinkedList<>();
        
        tambahAntrean(antrean, "D0013", "1208-A12", "Mahasiswa");     
        tambahAntrean(antrean, "A0012", "1208-B12", "Pengangguran");  
        tambahAntrean(antrean, "A0022", "1208-C12", "Calon Dokter");   
        tambahAntrean(antrean, "D002", "978-B2", "Dosen"); // Test Case gagal jika Dosen & Buku tidak terdaftar
        tambahAntrean(antrean, "A0022", "1208-A12", "Mahasiswa"); // Test Case gagal jika buku 1208-A12 sudah dipinjam Aldo
        
        System.out.println("Antrean berhasil dibuat.");

        // PROSES PEMINJAMAN
        System.out.println("    PROSES PEMINJAMAN    ");
        
        // Collections khusus untuk mencatat ISBN yang sedang dipinjam
        Set<String> bukuSedangDipinjam = new HashSet<>();

        // Proses dari urutan paling depan hingga habis
        while (!antrean.isEmpty()) {
            String prosesString = antrean.poll(); 
            
            // Memecah string berdasarkan karakter '#'
            String[] parts = prosesString.split("#");
            String idAnggotaPinjam = parts[0];
            String isbnPinjam = parts[1];

            System.out.println("-> Memproses: Anggota [" + idAnggotaPinjam + "] meminjam Buku [" + isbnPinjam + "]");

            //  Mengecek apakah ID Anggota terdaftar
            boolean isAnggotaValid = daftarAnggota.contains(new Anggota(idAnggotaPinjam, "", ""));

            // Mengecek apakah ISBN terdaftar di katalog buku
            boolean isBukuValid = katalogBuku.containsKey(isbnPinjam);

            // Mengecek apakah buku TIDAK sedang dipinjam
            boolean isBukuTersedia = !bukuSedangDipinjam.contains(isbnPinjam);

            // Ambil keputusan
            if (!isAnggotaValid) {
                System.out.println("   [PROSES DITOLAK] ID Anggota " + idAnggotaPinjam + " tidak terdaftar di sistem.");
            } else if (!isBukuValid) {
                System.out.println("   [PROSES DITOLAK] Buku dengan ISBN " + isbnPinjam + " tidak ada di katalog.");
            } else if (!isBukuTersedia) {
                System.out.println("   [PROSES DITOLAK] Buku " + isbnPinjam + " sedang dipinjam oleh orang lain.");
            } else {
                // Jika lolos semua syarat
                bukuSedangDipinjam.add(isbnPinjam);
                System.out.println("   [PROSES BERHASIL] Peminjaman dicatat.");
            }
        }
        
        System.out.println("Status Akhir Buku Sedang Dipinjam: " + bukuSedangDipinjam);
    }

    public static void tambahAntrean(Deque<String> antrean, String idAnggota, String isbn, String tipe) {
        String formatAntrean = idAnggota + "#" + isbn;
        if (tipe.equalsIgnoreCase("Dosen")) {
            antrean.addFirst(formatAntrean); 
        } else {
            antrean.addLast(formatAntrean);  
        }
    }
}