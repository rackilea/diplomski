void CheckStart()
{
    Scanner sc;
    try {
        sc = new Scanner (checkingFile);
    } catch (FileNotFoundException e){
        e.printStackTrace();
    }
    System.out.println("checking start");
    checkFileNull();
}