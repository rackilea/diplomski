private static boolean getSum(ArrayList<Integer> set, Integer sum, LinkedList<Integer> result) {
    // ...

    System.out.println("Left: Picking up " + set.get(0));
    result.add(set.get(0));
    if (getSum(newSet, sum - set.get(0), result)) {
        return true;
    }
    result.removeLast();

    System.out.println("Right: NOT Picking up " + set.get(0));
    if (getSum(newSet, sum, result)) {
        return true;
    }
}