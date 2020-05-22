public static void main(String[] args) {

      String toSplit = "abc#xyz#kml\\#ijk";

      String[] arr = toSplit.split("(?<!\\\\)#");

      System.out.println(Arrays.toString(arr));
}