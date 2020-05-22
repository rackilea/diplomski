static Integer [] divider(int n) {
    List<Integer> resultList = new ArrayList<Integer>();
    Integer [] result;
    for (int i = 1; i <= n/2; i++) {
       if (n%i == 0)
           resultList.add(i);
    }
    resultList.add(n);
    result = resultList.toArray(new Integer[resultList.size()]);

    return result;
}