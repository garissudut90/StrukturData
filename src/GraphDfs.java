import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphDfs {
    private int V; // Jumlah simpul
    private LinkedList<Integer>[] adj;
    private String[] labels; // Label node seperti a1, a2, dst

    private Map<Integer, Integer>nodeValues; // simpan nilai tiap node

    GraphDfs(int v) {
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

    boolean DFSFind(int v, int target, boolean[] visited) {
        visited[v] = true;
        System.out.println("Mengunjungi node: " + labels[v] + " Dengan nilai " + nodeValues.get(v));

        if (nodeValues.get(v) == target) {
            System.out.println("Ditemukan! Node " + labels[v] + " memiliki nilai " + target);
            return true;
        }

        for (int n: adj[v]) {
            if (!visited[n]) {
                if (DFSFind(n, target, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    void searchValue(int start, int target) {
        boolean[] visited = new boolean[V];
        if (!DFSFind(start, target, visited)) {
            System.out.println("Nilai " + target + " tidak ditemukan dalam graf.");
        }
    }

   public static void main(String[] args) {
    GraphDfs g = new GraphDfs(8);

        // Menentukan hubungan antar simpul (berarah)
        g.addEdge(0, 1); //a1 -> a2
        g.addEdge(0, 2); //a1 -> a3
        g.addEdge(1, 3); //a2 -> a4
        g.addEdge(1, 4); //a2 -> a5
        g.addEdge(2, 5); //a3 -> a6
        g.addEdge(2, 6); //a3 -> a7
        g.addEdge(3, 7); //a4 -> a8

        // menetapkan nilai node
        g.setNodeValue(0, 5); // a1
        g.setNodeValue(1, 88); // a2
        g.setNodeValue(2, 7); // a3
        g.setNodeValue(3, 8); // a4
        g.setNodeValue(4, 4); // a5
        g.setNodeValue(5, 10); // a6
        g.setNodeValue(6, 2); // a7
        g.setNodeValue(7, 25); // a8

        // Pencarian nilai
        int target = 4; // Ganti dengan nilai yang dicari
        System.out.println("Mencari nilai " + target + " dari simpul a1:");
        g.searchValue(0, target); // Mulai dari node a1 (index 0)
   }
}
