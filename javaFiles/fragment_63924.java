int[] arr = new int[]{1, 3, 4, 6, 7, 9, 10};
// for example starting from index 3 which is 6
ClusterRandom clusterDice = new ClusterRandom(arr.length, 3);
// ...
// in loop
return arr[clusterDice.nextInt()];