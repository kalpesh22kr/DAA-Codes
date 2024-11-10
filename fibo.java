import java.util.*;
public class fibo{

    // public static void fibonacci_nonrecurssive (int n){
    //     int a = 0;
    //     int b = 1;
    //     int result = 0;  
    //     for(int i=1; i<=n; i++){
    //     System.out.print(result+" ");
    //     a = b;
    //     b = result;
    //     result = a+b; 
    //     }
    // }

    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void printFibonacci(int n) {
        System.out.print("Fibonacci Sequence (Recursive): ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        // fibonacci_nonrecurssive(n);
        printFibonacci(n);
        sc.close();
    }
}

/*
iterative Approach:
Time Complexity: O(n)
Space Complexity: O(1)

Recursive Approach:
Time Complexity: O(2^n) (exponential due to redundant calculations)
Space Complexity: O(n) (due to the recursion stack)

For larger values of n, the iterative approach is preferable because of its efficiency.
*/