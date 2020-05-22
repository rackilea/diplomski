else if(input.contains("load"))
{
    String[] split = input.split(" ");
    Load load = new Load(split[1]);
    load.getFileContent();    // forgot to call
    System.out.print(">");
}