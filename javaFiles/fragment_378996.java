while ((line = bufferReader.readLine()) != null) {
    substring = line.substring(1, line.lastIndexOf(" ") + 1);
    priceSubstring = substring.substring(0,substring.indexOf(" "));

    quantitySubstring = substring.substring(substring.indexOf(" ") + 1 , substring.lastIndexOf(" ") );

    double price = Double.parseDouble(priceSubstring);
    double quantity = Double.parseDouble(quantitySubstring);

    priceArray.add(price);
    quantityArray.add(quantity);

    System.out.println(priceArray);
}