// fungsi single Linked List untuk menyimpan daftar buku perpustakaan
public class LinkedList {
    private Node head;
    private int jumlah;

    // untuk menambahkan buku baru di akhir daftar
    public boolean tambahBuku(String kode, String judul, String penulis) {
        if (cariBuku(kode) != null) {
            return false; // untuk kode buku tidak boleh sama
        }

        Node bukuBaru = new Node(kode, judul, penulis);
        if (head == null) {
            head = bukuBaru;
        } else {
            Node sekarang = head;
            while (sekarang.next != null) {
                sekarang = sekarang.next;
            }
            sekarang.next = bukuBaru;
        }
        jumlah++;
        return true;
    }

    // untuk menghapus buku terakhir dalam daftar.
    public Node hapusBuku() {
        if (head == null) {
            return null;
        }

        Node dihapus;
        if (head.next == null) { // jika hanya ada satu buku
            dihapus = head;
            head = null;
        } else {
            Node sekarang = head;
            while (sekarang.next.next != null) {
                sekarang = sekarang.next;
            }
            dihapus = sekarang.next;
            sekarang.next = null;
        }
        jumlah--;
        return dihapus;
    }

    // melakukan pengecekan node dari awal sampai kode buku ditemukan
    public Node cariBuku(String kode) {
        Node sekarang = head;
        while (sekarang != null) {
            if (sekarang.kodeBuku.equalsIgnoreCase(kode)) {
                return sekarang;
            }
            sekarang = sekarang.next;
        }
        return null;
    }

    // melakukan tampilan buku sesuai urutan masuk dan jumlah seluruh buku
    public void tampilkanBuku() {
        System.out.println("\nDaftar Buku:");
        if (head == null) {
            System.out.println("Daftar buku masih kosong.");
        }
        Node sekarang = head;
        while (sekarang != null) {
            System.out.println("Kode: " + sekarang.kodeBuku
                    + " | Judul: " + sekarang.judul
                    + " | Penulis: " + sekarang.penulis);
            sekarang = sekarang.next;
        }
        System.out.println("Total Buku: " + jumlah);
    }

    public int getJumlah() {
        return jumlah;
    }
}