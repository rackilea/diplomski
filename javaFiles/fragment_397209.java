List<String> myList = new ArrayList();
    myList.add("923119511824|DST:9900|CNT:1|OPR:zong|ADD RIDAsMs");
    myList.add("923119511824|DST:9900|CNT:1|OPR:zong|ADD sMs");
    myList.add("923125473547|DST:9900|CNT:1|OPR:zong|ADD SahafatMedia");

    Collections.sort(myList);

    System.out.println(myList.toString());

    for (int i = 0; i < myList.size() - 1; i++) {

        String currentEntry = myList.get(i);
        String nextEntry = myList.get(i + 1);

        StringTokenizer tokenizer = new StringTokenizer(currentEntry, "|");
        String currentNumber = tokenizer.nextToken();

        tokenizer = new StringTokenizer(nextEntry, "|");
        String nextNumber = tokenizer.nextToken();

        String lastToken = "";

        if (currentNumber.equals(nextNumber)) {

            System.out.println(currentNumber + " duplicate");

            while (tokenizer.hasMoreTokens()) {

                lastToken = tokenizer.nextToken();
            }

            System.out.println("last token: " + lastToken);
            int index = lastToken.indexOf(" ");
            System.out.println("What you probably want: " + lastToken.substring(index + 1));

        }

    }