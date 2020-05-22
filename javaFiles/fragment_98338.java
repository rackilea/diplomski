File file=new File("val.txt");
List<Double> value = new ArrayList<Double>();
Scanner input = new Scanner(file);
while(input.hasNextDouble()){
   value.add(input.nextDouble());
}