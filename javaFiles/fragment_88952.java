public int dynamicProgrammingSingleSellProfit(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }
        int profit = 0;
        int cheapest = arr[0];

        for (int i = 0; i < arr.length; i++) {

            cheapest = Math.min(cheapest, arr[i]);
            profit = Math.max(profit, arr[i] - cheapest);

        }
        return profit;
    }