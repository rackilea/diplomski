String str = "cobdate=01/28/2013 fundsnotextracted= elapsedtime=00:06:02 user=dataprod starttime=Wed, 30 Jan 2013 11:50:30 periods=DAILY, MTD, YTD knowledgedate=01/30/2013:11:50:10 progress=67 statusstep=Generating Reports .....";

// Split on a whitespace, followed by a sequence of letters ending with =.
// This ensures that you don't split on whitespace, optionally present in some values
String[] arr = str.split("[ ](?=[a-zA-Z]+=)");

for (String eachString : arr) {
    // Split on empty string following the = sign
    String[] tempArr = eachString.split("(?<==)");

    System.out.print(tempArr[0] + " ");

    // To ensure that you don't print a non-existence value.
    if (tempArr.length == 2) {
        System.out.println(tempArr[1]);
    } else {
        System.out.println();
    }
 }