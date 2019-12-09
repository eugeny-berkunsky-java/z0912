package logic;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private int n;
    Set<Edge> edges = new HashSet<>();

    public Graph(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
        edges.add(new Edge(to, from, weight));
    }

    public void removeEdge(int from, int to) {
        edges.removeIf(e -> e.getFrom()==from && e.getTo()==to);
        edges.removeIf(e -> e.getFrom()==to && e.getTo()==from);
    }

    public int[][] findWays() {
        int[][] w = new int[n+1][n+1];
        for (Edge edge : edges) {
            w[edge.getFrom()][edge.getTo()] = edge.getWeight();
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) if (i!=j) {
                    if (w[i][k]!=0 && w[k][j]!=0) {
                        int s = w[i][k] + w[k][j];
                        if (w[i][j]==0 || w[i][j]>s) {
                            w[i][j] = s;
                        }
                    }
                }
            }
        }
        return w;
    }
}
