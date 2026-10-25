public class Praktikum2 {
    // Merge sort data dari terbesar ke terkecil
    static void mergeSort(int[] a, int kiri, int kanan) {
        if (kiri >= kanan) return; // base case 1 elemen
        int tengah = (kiri + kanan) / 2;
        mergeSort(a, kiri, tengah); // urutkan bagian kiri
        mergeSort(a, tengah + 1, kanan); //urutkan bagian kanan
        merge(a, kiri, tengah, kanan); //gabungkan
        
    }

    static void merge(int[] a, int kiri, int tengah, int kanan) {
        int[] temp = new int[kanan - kiri + 1];
        int i = kiri, j = tengah + 1, k = 0;

        while (i <= tengah && j <= kanan) {
            if (a[i] >= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= tengah) temp[k++] = a[i++];
        while (j <= kanan) temp[k++] = a[j++];

        for (int x = 0; x < temp.length; x++) {
            a[kiri + x] = temp[x];
        }
    }

    static void cetak(String judul, int[] a){
        System.out.print(judul + ": ");
        for (int n : a) System.out.print(n + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] dataMerge = {38, 27, 43, 3, 9, 82, 10, 27};

        cetak("Merge Sort - sebelum", dataMerge);
        mergeSort(dataMerge, 0, dataMerge.length - 1);
        cetak("Merge Sort - sesudah", dataMerge);

        System.out.println();
    }
}
