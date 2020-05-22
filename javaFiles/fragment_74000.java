double average=0;
double total=0;
for (Map.Entry<Integer, Integer> entry : rolls.entrySet()) 
{
    total+=entry.getKey()*entry.getValue();
    System.out.println(("Antal kast som gav "+entry.getKey()) + ": " + entry.getValue());
}

average = total/amount;
System.out.println("Average : "+average);