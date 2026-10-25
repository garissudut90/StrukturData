
import java.util.LinkedList;

public class StrukturData {
    public static void main(String[] args) {
        // No. 1 Variabel tipe integer dengan nama StrukturBaris
        int StrukturBaris;

        // No. 2 variabel tipe string dengan nama KataBaru
        String KataBaru = "Aditya";

        System.out.println("Kata Baru : " + KataBaru);

        // No. 3 Array Satu dimensi dengan nama empatAngka tipe data integer
        int[] empatAngka = {05, 10, 20, 88};

        System.out.println("Empat Angka : ");
        for (int i : empatAngka) {
            System.out.print(i + "");
        }
        System.out.println("");

        // No. 4 Array Dua Dimensi dengan nama Angka tipe data String
        String[][] Angka = {
            {"05", "3", "5"},
            {"14", "19", "20"},
            {"22", "27", "88"}
        };

        System.out.println("Angka : ");
        for (int i = 0; i < Angka.length; i++) {
            for (int j = 0; j < Angka[1].length; j++) {
                System.out.print(Angka[i][j]);
            }
            System.out.println();
        }
    
        // No. 5 Linked List dengan nama listAngka
        LinkedList<Integer> listAngka = new LinkedList<>();
        listAngka.add(05);
        listAngka.add(19);
        listAngka.add(44);
        listAngka.add(60);
        listAngka.add(88);

        System.out.println("List Angka : " + listAngka);

    }
}
