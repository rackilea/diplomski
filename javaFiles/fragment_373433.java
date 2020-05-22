public String randomiseStringOfNumbers(String numbers) throws NumberFormatException{
    String[] sNumbers = numbers.split(" ");
    ArrayList<Integer> iNumbers = new ArrayList<Integer>();
    for(String s : sNumbers){
        iNumbers.add(Integer.parseInt(s));
    }
    Collections.shuffle(iNumbers);
    String sn = "";
    for(Integer i : iNumbers){
        sn = sn + i.toString() + " ";
    }
    return sn;
}