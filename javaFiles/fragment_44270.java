int trues = 0;
int falses = 0;
int firstindex = -1;//first index init with -1 to check with it later
String del = "";
int i = 0;
while (scan.hasNextLine()) {
    String line = scan.next();
    if (line.equals("true")) {//if the line equal true then trues++;
        if (firstindex == -1) {//if the first index == -1 then assign 
                               //it to i number of words
            firstindex = i;
        }
        trues++;
    } else if (line.equals("false")) {//if the line equal false falses++
        falses++;
    }
    System.out.print(del + line);
    del = ",";
    i++;
}
System.out.println();
System.out.println("Total TRUEs: " + trues);
System.out.println("Total TRUEs: " + falses);
System.out.println("Index of first TRUE: " + 
                      (firstindex > -1 ? firstindex : "No true in file"));