package main;

import logic.Graph;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run0();
    }

    private void run() {
        Graph g = new Graph(5);
        g.addEdge(1,2,1);
        g.addEdge(1,3,5);
        g.addEdge(2,3,3);
        g.addEdge(2,5,7);
        g.addEdge(3,5,4);
        g.addEdge(2,4,10);
        g.addEdge(5,4,1);

        int[][] w = g.findWays();
        for (int i = 1; i < w.length ; i++) {
            for (int j = 1; j < w[i].length; j++) {
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void run1() {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= 1000_000; i++) {
            list.add(i);
        }
        long start = System.currentTimeMillis();
        boolean f = false;
        while (list.size() > 1) {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                it.next();
                if (f) it.remove();
                f = !f;
            }
        }
        long finish = System.currentTimeMillis();
        System.out.println(list.get(0));
        System.out.println(finish-start);
    }

    // Now it's correct
    private void run0() {
        List<Integer> list = new ArrayList<>(Arrays.asList(
                3, 1, 2, 3, 4, 6, 7, 0, -3, 4, -7, 11, -11, 23, -16, 10
        ));
        int x = new Scanner(System.in).nextInt();
        int left = 0;
        int right = list.size() - 1;
        do {
            int a;
            do {
                a = list.get(left);
                if (a < x) left++;
            } while (a < x);
            int b;
            do {
                b = list.get(right);
                if (b > x) right--;
            } while (b > x);
            if (left <= right) {
                int t = list.get(left);
                list.set(left,list.get(right));
                list.set(right,t);
                left++; right--;
            }
        } while (left <= right);
        System.out.println(list);
    }
}
