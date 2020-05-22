while(true) {
    try{
        String fName = inScan.nextLine();
        fScan = new Scanner(new File(fName));
        break;
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("Your file is invalid -- please re-enter");
    }
}