import java.util.Arrays;

class Item {
    int profit, weight;

    Item(int profit, int weight) {
        this.profit = profit;
        this.weight = weight;
    }
}

public class fractional_knapsack {

    // Method to calculate the maximum value we can get in the knapsack
    public static double getMaxValue(Item[] arr, int capacity) {
        Arrays.sort(arr, (item1, item2) ->
                Double.compare((double) item2.profit / item2.weight, (double) item1.profit / item1.weight)
        );

        double totalValue = 0.0;

        for (Item i : arr) {
            int curWt = i.weight;
            int curVal = i.profit;

            if (capacity - curWt >= 0) {
                // Take the whole item
                capacity -= curWt;
                totalValue += curVal;
            } else {
                // Take fraction of the remaining item
                double fraction = (double) capacity / curWt;
                totalValue += (curVal * fraction);
                break;
            }
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] arr = { new Item(30, 5), new Item(40, 10), new Item(45, 15),new Item(77,22),new Item(90,25) };
        int capacity = 60;

        double maxValue = getMaxValue(arr, capacity);
        System.out.println("Maximum value we can obtain = " + maxValue);
    }
}