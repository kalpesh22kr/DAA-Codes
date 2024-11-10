import java.util.*;

public class quick_sort {
    private static final Random random = new Random();

    // Deterministic Quick Sort
    public static void deterministicQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = deterministicPartition(arr, low, high);
            deterministicQuickSort(arr, low, pivotIndex - 1);
            deterministicQuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int deterministicPartition(int[] arr, int low, int high) {
        int pivot = arr[low];  // Choose the first element as the pivot
        int i = low;
        int j = high;
    
        while (i < j) {
            // Increment i until an element greater than the pivot is found
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
    
            // Decrement j until an element less than or equal to the pivot is found
            while (arr[j] > pivot && j >= low + 1) {
                j--;
            }
    
            // Swap elements at i and j if i is less than j
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    
        // Place the pivot in the correct position
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
    
        return j;  // Return the index of the pivot
    }
    

    // Randomized Quick Sort
    public static void randomizedQuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = randomizedPartition(arr, low, high);
            randomizedQuickSort(arr, low, pivotIndex - 1);
            randomizedQuickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int randomizedPartition(int[] arr, int low, int high) {
        int randomPivotIndex = low + random.nextInt(high - low + 1);
        swap(arr, randomPivotIndex, high); // Move the random pivot to the end
        return deterministicPartition(arr, low, high);
    }

    // Swap helper function
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 7, 8, 9, 1, 5};
        int[] arr2 = {10, 7, 8, 9, 1, 5};

        System.out.println("Original Array: " + Arrays.toString(arr1));

        // Deterministic Quick Sort
        deterministicQuickSort(arr1, 0, arr1.length - 1);
        System.out.println("Sorted array (Deterministic): " + Arrays.toString(arr1));

        // Randomized Quick Sort
        randomizedQuickSort(arr2, 0, arr2.length - 1);
        System.out.println("Sorted array (Randomized): " + Arrays.toString(arr2));
    }
}

 /*
 Best Case (Balanced Partitions)
    Best Case Time Complexity: O(nlogn)
 Average Case
    Average Case Time Complexity: O(nlogn)
 Worst Case (Unbalanced Partitions)
    Worst Case Time Complexity: O(n*n)

    Space Complexity:
    Avg and best case: O(logn)
    Worst Case : O(n)
    


*/