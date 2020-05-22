public static void main(String[] args) throws Exception {
    double d1 = 7d / 3;
    double d2 = 5d / 3;
    System.out.println(new BigDecimal(d1)); //2.333333333333333481363069950020872056484222412109375
    System.out.println(new BigDecimal(d2)); //1.6666666666666667406815349750104360282421112060546875
    System.out.println(new BigDecimal(d1).add(new BigDecimal(d2))); //4.0000000000000002220446049250313080847263336181640625
    double sum = d1 + d2; 
    System.out.println(new BigDecimal(sum)); //4
}