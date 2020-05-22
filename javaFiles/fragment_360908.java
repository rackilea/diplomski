//Create Set iterator
Iterator iterator;
iterator = tSet.iterator();

try
{
    PrintWriter report= new PrintWriter("txtx.txt");

    while(iterator.hasNext()){
        report.println(iterator.next()+ " ");
        report.flush();
    }

    report.close();
}
catch (IOException e) {
    System.out.println("Error could not write to location");
}