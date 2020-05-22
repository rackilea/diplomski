public static void main (String[] args){
        String finalPrice = null;
        String price = "Price : \"$10.35\"";
        String regex = "Price\\s:\\s\"\\$(\\d+.\\d+)\"";
        Pattern Pricepattern = Pattern.compile(regex);
        Matcher Pricematcher = Pricepattern.matcher(price);
        if(Pricematcher.find()) {  //we've found a match
            finalPrice = Pricematcher.group(1);
        }
        float parsedPrice = Float.parseFloat(finalPrice);
        System.out.println(parsedPrice);
    }