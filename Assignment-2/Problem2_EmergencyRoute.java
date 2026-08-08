import java.io.*;
import java.util.*;

public class Problem2_EmergencyRoute {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // Adjacency list
        List<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Read roads
        for (int i = 0; i < m; i++) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        // Distance array
        int[] distance = new int[n + 1];

        Arrays.fill(distance, -1);

        // BFS queue
        Queue<Integer> queue = new LinkedList<>();

        // Start from city 1
        distance[1] = 0;
        queue.add(1);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int neighbor : graph[current]) {

                // If city has not been visited
                if (distance[neighbor] == -1) {

                    distance[neighbor] = distance[current] + 1;

                    queue.add(neighbor);
                }
            }
        }

        // Count efficiently reachable cities
        int count = 0;

        for (int i = 1; i <= n; i++) {

            if (distance[i] != -1 && distance[i] <= d) {
                count++;
            }
        }

        System.out.println(count);
    }
}