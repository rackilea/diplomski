public static void main(String[] args)  {
    String s = "ONE\tTWO\t\tTHREE";
    String[] d = s.split("\\t{1,2}");
    for(String e : d) {
        System.out.println(e);
    }

}