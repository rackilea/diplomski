List<Double> a = new ArrayList<Double>();
scanner = new Scanner(System.in);        
while (scanner.hasNext()) {
   String number  = scanner.next();
   NumberFormat numberFormat = NumberFormat.getInstance();
   a.add(numberFormat.parse(number).doubleValue());
}