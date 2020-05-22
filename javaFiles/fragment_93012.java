int count = 1;
while(read.hasNextLine()) {
    String nextLine = read.nextLine();
        System.out.println(account.toString(nextLine));
    if(count %4==0) {
        vector.addAccount(nextLine);
    }
    count++;
}