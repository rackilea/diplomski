String[] numbers ={"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000"};
    List<BigDecimal> decimalList = new ArrayList<>();
    for(String s: numbers){
        decimalList.add(new BigDecimal(s));
    }
    Collections.sort(decimalList);
    Collections.reverse(decimalList);     // edit , forgot this line
    decimalList.forEach(System.out::println);