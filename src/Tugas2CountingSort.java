public class Tugas2CountingSort {
    public static void main(String[] args) {
        int[] data = {25, 15, 5, 60, 51, 32, 40, 8};

        System.out.println("Data sebelum diurutkan: ");
        for (int x: data) {
            System.out.print(x + " ");
        }
        System.out.println();

        int maks = data[0];
        for (int x: data) {
            if (x > maks){
                maks = x;
            }
        }

        int[] hitung = new int[maks + 1];

        for (int x : data) {
            hitung[x]++;
        }

        int k = 0;
        for (int i = maks; i >= 0; i--) {
            while (hitung[i] > 0) {
                data[k] = i;
                k++;
                hitung[i]--;
            }
        }

        System.out.println("Data dari terbesar ke terkecil: ");
        for (int x: data) {
            System.out.print(x + " ");
        }
    }
}
