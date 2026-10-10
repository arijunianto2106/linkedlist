import java.util.Scanner;

public class Perpustakaan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList daftarBuku = new LinkedList();
        boolean berjalan = true;

        // pada menu akan menampilkan hingga user memilih keluar.
        while (berjalan) {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = input.nextLine().trim();

            switch (pilihan) {
                case "1":
                    System.out.print("Masukkan Kode Buku: ");
                    String kode = input.nextLine().trim();
                    // Kode buku harus diisi dan panjangnya maksimal 5 karakter.
                    if (kode.isEmpty() || kode.length() > 5) {
                        System.out.println("Kode buku harus diisi dan maksimal 5 karakter.");
                        break;
                    }
                    if (daftarBuku.cariBuku(kode) != null) {
                        System.out.println("Kode buku sudah digunakan.");
                        break;
                    }

                    System.out.print("Masukkan Judul: ");
                    String judul = input.nextLine().trim();
                    System.out.print("Masukkan Penulis: ");
                    String penulis = input.nextLine().trim();
                    if (judul.isEmpty() || penulis.isEmpty()) {
                        System.out.println("Judul dan penulis tidak boleh kosong.");
                        break;
                    }
                    daftarBuku.tambahBuku(kode, judul, penulis);
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case "2":
                    Node bukuDihapus = daftarBuku.hapusBuku();
                    if (bukuDihapus == null) {
                        System.out.println("Tidak ada data untuk dihapus.");
                    } else {
                        System.out.println("Buku terakhir berhasil dihapus: "
                                + bukuDihapus.kodeBuku + " (" + bukuDihapus.judul + ").");
                    }
                    break;

                case "3":
                    System.out.print("Masukkan Kode Buku: ");
                    String kodeCari = input.nextLine().trim();
                    Node ditemukan = daftarBuku.cariBuku(kodeCari);
                    if (ditemukan == null) {
                        System.out.println("Buku tidak ditemukan.");
                    } else {
                        System.out.println("Buku ditemukan:");
                        System.out.println("Kode: " + ditemukan.kodeBuku);
                        System.out.println("Judul: " + ditemukan.judul);
                        System.out.println("Penulis: " + ditemukan.penulis);
                    }
                    break;

                case "4":
                    daftarBuku.tampilkanBuku();
                    break;

                case "5":
                    // harus minimal 5 buku tersimpan jika ingin end program
                    if (daftarBuku.getJumlah() < 5) {
                        System.out.println("Minimal 5 buku harus ada sebelum keluar.");
                        System.out.println("Jumlah buku saat ini: " + daftarBuku.getJumlah());
                    } else {
                        System.out.println("Program selesai. Terima kasih!");
                        berjalan = false;
                    }
                    break;

                default:
                    System.out.println("Menu tidak tersedia. Silakan pilih 1 sampai 5.");
            }
        }
        input.close();
    }
}