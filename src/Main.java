import java.util.*;
import java.io.*;
public class Main {
    // The trick is to find that if the order of inputs are not sequential (+1)
    // , then that is an outlier and also the minimal amount needed because i adds up the number of amounts.
    // If there are over two outliers, then the group is impossible.
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter("factory.out");

        int N = sc.nextInt();
        int[][] graph = new int[N][2];
        for (int i = 0; i < N-1; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
        }
        for (int[] i : graph) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            boolean good = true;
            for (int j = 0; j < N; j++) {
                if (graph[j][0] == i) {
                    good = false;
                    break;
                }
            }
            if (good) {
                list.add(i);
            }
        }
        if (list.size() > 1) { pw.println(-1);}
        else { pw.println(list.get(0));}
        pw.close();
    }
}