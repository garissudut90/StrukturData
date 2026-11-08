import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    private int[] nilai;      // nilai tiap node a1..a8
    private boolean ketemu = false;
    private int langkah = 0;

    Graph(int V, int[] nilai) {
        this.V = V;
        this.nilai = nilai;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList<Integer>();
    }

    // graf tidak berarah: tambah dua arah
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    String nama(int v) {
        return "a" + (v + 1) + "(" + nilai[v] + ")";
    }

    void DFSUtil(int v, boolean visited[], int n) {
        visited[v] = true;
        System.out.println("Langkah " + (++langkah) + ": kunjungi " + nama(v));

        if (nilai[v] == n) {
            System.out.println(">> Angka " + n + " DITEMUKAN di node " + nama(v));
            ketemu = true;
            return;
        }

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext() && !ketemu) {
            int w = i.next();
            if (!visited[w]) {
                DFSUtil(w, visited, n);
                if (!ketemu)
                    System.out.println("   backtrack ke " + nama(v));
            }
        }
    }

    void DFS(int awal, int n) {
        boolean visited[] = new boolean[V];
        DFSUtil(awal, visited, n);
        if (!ketemu)
            System.out.println(">> Angka " + n + " tidak ditemukan");
    }

    public static void main(String[] args) {
        //              a1  a2  a3 a4  a5  a6  a7 a8
        int[] nilai = {12, 88, 7, 23, 54, 31, 9, 18};
        Graph g = new Graph(8, nilai);

        g.addEdge(0, 1); // a1 - a2
        g.addEdge(0, 2); // a1 - a3
        g.addEdge(1, 3); // a2 - a4
        g.addEdge(1, 4); // a2 - a5
        g.addEdge(2, 5); // a3 - a6
        g.addEdge(2, 6); // a3 - a7
        g.addEdge(4, 7); // a5 - a8
        g.addEdge(5, 7); // a6 - a8

        int n = 31;
        System.out.println("DFS mencari " + n + " (node awal a1)");
        g.DFS(0, n);
    }
}