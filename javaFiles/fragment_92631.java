public static void main(String args[]) {
  String s = "HeFNeO2H3Be1H";
  String[] r = s.split("(?=[A-Z0-9])");
    for (int i = 0; i<r.length; i++){
        System.out.println(""+r[i]);
    }
}