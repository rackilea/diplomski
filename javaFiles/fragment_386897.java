public void writeBalanceFile(String account, double balance) throws 
FileNotFoundException {
    PrintWriter outFile = new PrintWriter(new FileOutputStream(new 
            File(account + "_balance.txt")));
    outFile.print(balance);

    outFile.close();
}