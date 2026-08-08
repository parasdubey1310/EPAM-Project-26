import java.io.*;
import java.util.*;

public class Problem1_TrustedServers {

    static int n;
    static long k;
    static long[] key;
    static List<Integer>[] graph;
    static int count = 0;

    static void dfs(int node, int parent, long currentXor) {

        // Check whether current server is trusted
        if (currentXor >= k) {
            count++;
        }

        // Visit all children
        for (int neighbor : graph[node]) {

            if (neighbor == parent) {
                continue;
            }

            long childXor = currentXor ^ key[neighbor];

            dfs(neighbor, node, childXor);
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        key = new long[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            key[i] = Long.parseLong(st.nextToken());
        }

        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Read tree edges
        for (int i = 0; i < n - 1; i++) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // Start DFS from root server 1
        dfs(1, 0, key[1]);

        System.out.println(count);
    }
}