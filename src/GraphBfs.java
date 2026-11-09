import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphBfs {
    private int V; // Jumlah simpul
    private LinkedList<Integer>[] adj;
    private String[] labels; // label node seperti a1, a2, dst

    private Map<Integer, Integer> nodeValues; // Simpan nilai tiap node

    @SuppressWarnings("unchecked")
    GraphBfs(int v) {
        V = v;
        adj = new LinkedList[v];
        labels = new String[v];
        nodeValues = new HashMap<>();

        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
            labels[i] = "a" + (i + 1);
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void setNodeValue(int nodeIndex, int value) {
        nodeValues.put(nodeIndex, value);
    }

    boolean BFSFind(int start, int target) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);
        System.out.println("Masukan " + labels[start] + " ke antrian");

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.println("Mengunjungi node: " + labels[v] + " dengan nilai " + nodeValues.get(v));


            if (nodeValues.get(v) == target) {
                System.out.println("Ditemukan! Node " + labels[v] + " memiliki nilai " + target);
                return true;
            }

            for (int n : adj[v]) {
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                    System.out.println(" Masukan " + labels[n] + " ke antrian");
                }
            }
        }
        return false;
    }

    void searchValue(int start, int target) {
        if (!BFSFind(start, target)) {
            System.out.println("Nilai " + target + " tidak ditemukan dalam graph.");
        }
    }


    public static void main(String[] args) {
        GraphBfs g = new GraphBfs(8);

        // Hubungan antar simpul
        g.addEdge(0, 1); // a1 -> a2
        g.addEdge(0, 2); // a1 -> a3
        g.addEdge(1, 3); // a2 -> a4
        g.addEdge(1, 4); // a2 -> a5
        g.addEdge(2, 5); // a3 -> a6
        g.addEdge(2, 6); // a3 -> a7
        g.addEdge(3, 7); // a4 -> a8

        // Nilai Node
        g.setNodeValue(0, 5);
        g.setNodeValue(1, 88);
        g.setNodeValue(2, 12);
        g.setNodeValue(3, 52);
        g.setNodeValue(4, 2);
        g.setNodeValue(5, 10);
        g.setNodeValue(6, 4);
        g.setNodeValue(7, 15);
        g.setNodeValue(7, 21);


        int target = 4; // nilai yang dicari
        System.out.println("Mencari nilai " + target + " dari simpul a1:");
        g.searchValue(0, target);
    }
}
