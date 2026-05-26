import java.util.*;
public class SistemBioskop {
    public static void main(String[] args) {

        Map<String, Film> jadwalFilm = new HashMap<>();
        jadwalFilm.put("F12", new Film("The Big 4", 45000));
        jadwalFilm.put("F13", new Film("Mencuri Raden Saleh", 50000));
        jadwalFilm.put("F14", new Film("Pertaruhan The Movie 2", 40000));

        Set<String> kursiTerpesan = new HashSet<>();

        List<Transaksi> riwayatTransaksi = new ArrayList<>();

        System.out.println("   SIMULASI KASIR BIOSKOP XX1    ");

        //  Simulasi Pemesanan 
        // 3 pesanan sukses, 1 pesanan gagal 
        prosesPesanan("Budi", "F12", "A1", jadwalFilm, kursiTerpesan, riwayatTransaksi);
        prosesPesanan("Siti", "F12", "A2", jadwalFilm, kursiTerpesan, riwayatTransaksi);
        prosesPesanan("Andi", "F12", "B4", jadwalFilm, kursiTerpesan, riwayatTransaksi);
        
        // Simulasi Error
        prosesPesanan("Joko", "F12", "A1", jadwalFilm, kursiTerpesan, riwayatTransaksi);

        //  Cetak Riwayat
        System.out.println("    RIWAYAT TRANSAKSI HARI INI    ");
        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
        } else {
            for (int i = 0; i < riwayatTransaksi.size(); i++) {
                System.out.println((i + 1) + ". " + riwayatTransaksi.get(i));
            }
        }
    }

    public static void prosesPesanan(String nama, String kodeFilm, String kursi, Map<String, Film> jadwal, Set<String> kursiTerpesan, List<Transaksi> riwayat) {
        System.out.println("-> Memproses pesanan atas nama: " + nama);
        
        // Cek kode film di sistem
        if (!jadwal.containsKey(kodeFilm)) {
            System.out.println("   [PESANAN DITOLAK] Kode Film '" + kodeFilm + "' tidak ditemukan.");
            return; 
        }

        // Cek kursi tersedia
        if (!kursiTerpesan.add(kursi)) {
            System.out.println("   [PESANAN DITOLAK] Kursi " + kursi + " yang lo pilih sudah diambil bray sama yang laen");
            return; 
        }

        // Syarat terpenuhi->Cetak
        Film filmDipilih = jadwal.get(kodeFilm);
        Transaksi trxBaru = new Transaksi(nama, filmDipilih.judul, kursi, filmDipilih.harga);
        riwayat.add(trxBaru);
        
        System.out.println("   [BERHASIL] Tiket " + filmDipilih.judul + " (Kursi " + kursi + ") berhasil dipesan.");
    }
}