String[] books = new String[3];
books[0] = "book1";
books[1] = "book2";
books[2] = "book3";
boolean flag = true;
while(flag){ //outer loop 
    int counter = 0; //check for total right answers
    for(int i=0;i<books.length;i++){ //iterate over all books
        System.out.print("Choose book " + (i+1) +" name: ");
        String userinput= s.nextLine();

        if (Arrays.asList(userinput).contains(books[i])) {
            counter++;
            System.out.println("right, what is the next book?");


            if(counter == books.length){ //in case all choices are correct
                flag = false;
            }
        } else {
            System.out.println("Wrong");
            break;//terminate inner loop
        }
    }
}