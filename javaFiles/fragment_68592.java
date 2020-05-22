public static void getAllSubsets(int[] elements, int sum) {
    getAllSubsets(elements, 0, sum, new Stack<Integer>());
}
private static void getAllSubsets(int[] elements, int i, int sum, Stack<Integer> currentSol) { 
    //stop clauses:
    if (sum == 0 && i == elements.length) System.out.println(currentSol);
    //if elements must be positive, you can trim search here if sum became negative
    if (i == elements.length) return;
    //"guess" the current element in the list:
    currentSol.add(elements[i]);
    getAllSubsets(elements, i+1, sum-elements[i], currentSol);
    //"guess" the current element is not in the list:
    currentSol.pop();
    getAllSubsets(elements, i+1, sum, currentSol);
}