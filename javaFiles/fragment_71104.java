try(
    Scanner input = new Scanner(source);
    PrintWriter output = new PrintWriter(temp);
){
    ...
    temp.renameTo(source);
    source.delete();
}