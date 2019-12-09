package main;

import logic.Graph;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        new Main().run();
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

    //TODO don't works
    private void run0() {
        List<Integer> list = new ArrayList<>(Arrays.asList(
                3, 1, 2, 3, 4, 6, 7, 0, -3, 4, -7, 11, -11, 23, -16, 10
        ));
        int x = new Scanner(System.in).nextInt();
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            int a;
            for (; ; ) {
                a = list.get(left);
                if (a < x) left++;
                else break;
            }

            int b;
            for (; ; ) {
                b = list.get(right);
                if (b >= x) right--;
                else break;
            }
            list.set(left, b);
            list.set(right, a);
            //left++; right--;
        }
        System.out.println(list);
    }
}
