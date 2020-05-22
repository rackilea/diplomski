public static void main(String[] args) throws Exception {
    double value = 3560;
    System.out.println(value + " milliamps");
    //Milliamps to centiamps is a factor of .1
    System.out.println(getFormattedValue(value, .1) + " centiamps");
    //Milliamps to deciamps is a facotr of .01
    System.out.println(getFormattedValue(value, .01) + " deciamps");
    //Milliamps to amps is a factor of .001
    System.out.println(getFormattedValue(value, .001) + " amps");

}