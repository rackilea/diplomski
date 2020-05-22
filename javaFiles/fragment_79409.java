int count = 0;
while (scan.hasNext()) {
        String line = scan.nextLine();
        //Scanner to read individual items from a string 
        Scanner lineScan = new Scanner(line);
        lineScan.useDelimiter(",");
        String question = lineScan.next();
        String answer = lineScan.next();

        if (count < 5)
          //lineScan contains one of the first 5 lines
          //call a method to do something with these lines here
        else {
          //Create the new Wordpair
          Wordpair wp = new Wordpair(question, answer);
          //Add the new wordpair to the list
          temp.add(wp);
        }

        count++;
    }