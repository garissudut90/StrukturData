public class MergeSort {
    // Mengurutukan data terbesar ke terkecil

    public static void main(String[] args) {
        int[] data = {20, 5, 45, 30, 61, 15, 72, 54};

        System.out.println("Data sebelum diurutkan: ");
        for (int x: data) {
            System.out.print(x + " ");
        }
        System.out.println();

        mergeSort(data, 0, data.length -1);

        System.out.println  ("Data dari terbesar ke terkecil: ");
        for (int x: data) {
            System.out.print(x + " ");
        }
    }

    static void mergeSort(int[] data, int kiri, int kanan) {
        if (kiri < kanan) {
            int tengah = (kiri + kanan) / 2;

            mergeSort(data, kiri, tengah);
            mergeSort(data, tengah + 1, kanan);

            merge(data, kiri, tengah, kanan);
        }
    }

    static void merge(int[] data, int kiri, int tengah, int kanan) {
        int[] temp = new int[kanan - kiri + 1];
        int i = kiri, j = tengah + 1, k = 0;

        while (i <= tengah && j <= kanan) {
            if (data[i] >= data[j]) {
                temp[k++] = data[i++];
            } else {
                temp[k++] = data[j++];
            }
        }

        while (i <= tengah) {
            temp[k++] = data[i++];
        }

        while (j <= kanan) {
            temp[k++] = data[j++];
        }

        for (i = 0; i < temp.length; i++) {
            data[kiri +i] = temp[i];
        }

    }

}