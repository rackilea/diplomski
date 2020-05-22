private static void solve(Triangle triangle) {

    System.out.println(triangle);

    ArrayList<Integer> result = new ArrayList<Integer>();
    int total = 0;

    for(Row row  : triangle){
        Collections.sort(row);
        total += row.get(row.size()-1);
        result.add(row.get(row.size()-1));
    }

    for(Integer intr : result)
        System.out.println("Largest elements of the rows: " + intr);
    System.out.println("Total: " + total);
}