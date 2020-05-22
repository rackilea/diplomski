public static double result(ArrayList<String> mySequence, double total, int index)
{
    if (index == 0)
        total = Double.parseDouble(mySequence.get(index));

    if (index == (mySequence.size() - 1))
        return total;
    else if (mySequence.get(index).equals("*"))
        total *= Double.parseDouble(mySequence.get(index + 1));
    else if (mySequence.get(index).equals("/"))
        total /= Double.parseDouble(mySequence.get(index + 1));
    else if (mySequence.get(index).equals("+"))
    {
        index++;
        double start = Double.parseDouble(mySequence.get(index));
        total += result(mySequence, start, index);
        return total;
    }
    else if (mySequence.get(index).equals("-"))
    {
        index++;
        double start = Double.parseDouble(mySequence.get(index));
        total -= result(mySequence, start, index);
        return total;
    }

    index++;
    return result(mySequence, total, index);

}

public static void main(String args[])
{
    ArrayList<String> splitEquation = 
        new ArrayList<String>(
            Arrays.asList("5","*","5","/","5","*","4","-","3","*","8"));

    double myResult = result(splitEquation, 0, 0); 
    System.out.println("Answer is: " + myResult);
}