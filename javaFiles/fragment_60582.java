Collection<Integer> integers= new ArrayList<>();
Collection<Double> doubles = new ArrayList<>();

while(input.hasNext())
{

 if (input.hasNextInt()) {
     integers.add(input.nextInt());
}else if(input.hasNextDouble()) {
     doubles.add(input.nextDouble());
}else
     input.next(); // will simply move to next value in the line
}