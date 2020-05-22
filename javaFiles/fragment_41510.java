private static void splitWithPipe() {
    String s = "asadsdas357902||190||RUE RACHELLE||ST|||LES CÈDRES|J7T1J9|QC";
    for (int i = 0; i < 10; i++) {
        String a[] = s.split("asadsdas357902|", i); 
        System.out.println(Arrays.toString(a));
    }
}