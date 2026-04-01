
        import java.util.Scanner;
import java.util.HashMap;

public class SubarraysDivByK {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read n (size) and k (divisor)
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();

        // Use a HashMap to store the frequency of remainders
        // Key: Remainder, Value: Count of times it has occurred
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Base case: a remainder of 0 has occurred once (before any elements)
        map.put(0, 1);

        int count = 0;
        int runningSum = 0;

        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                runningSum += sc.nextInt();
                
                // Calculate remainder
                int rem = runningSum % k;
                
                // Handle negative remainders in Java to keep them positive
                if (rem < 0) {
                    rem += k;
                }

                // If this remainder has been seen before, it means the subarray 
                // between those two points is divisible by k.
                if (map.containsKey(rem)) {
                    count += map.get(rem);
                    map.put(rem, map.get(rem) + 1);
                } else {
                    map.put(rem, 1);
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
    

