public class knapsack {
    public static void main(String[] args) {
        int[] profit = {10,15,40};
        int[] weight = {1,2,3};
        int capacity = 6;
        int ans = getMax(profit,weight,capacity);
        System.out.println(ans);
    }
    public static int getMax(int[] profit, int[] weight, int capacity){
        int[][] dp = new int[weight.length+1][capacity+1];
        for(int i = 1 ; i <= weight.length ; i++){
            for(int j = 1 ;j <= capacity ;j++){
                if(weight[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i-1]]+profit[i-1]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[weight.length][capacity];
    }
}