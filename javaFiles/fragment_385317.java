private static void printSeq(String in , List<Integer> seq)
{
    String seqStr = "";

    //convert the sequence of indices into the string represented
    //by seq
    for(int i : seq)
        seqStr += in.charAt(i);

    System.out.println(seq + " => " + seqStr);
}