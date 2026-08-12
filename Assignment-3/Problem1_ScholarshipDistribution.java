import java.util.*;

public class Problem1_ScholarshipDistribution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long budget = sc.nextLong();

        int[] scholarship = new int[n];

        for (int i = 0; i < n; i++) {
            scholarship[i] = sc.nextInt();
        }

        Arrays.sort(scholarship);

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (scholarship[i] <= budget) {
                budget -= scholarship[i];
                count++;
            } else {
                break;
            }
        }

        System.out.println(count);

        sc.close();
    }
}