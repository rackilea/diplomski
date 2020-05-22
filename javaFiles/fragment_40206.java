public void open() throws Exception {

       try (Scanner fileInput = new Scanner(new File("libraryItems.txt"))) { // try-with resources makes sure that the Scanner is closed even on an error

          fileInput.useDelimiter("%");

          System.out.println("File opened!"); // Debugging console output

           while (fileInput.hasNext()) {
               MediaItem mItem = new MediaItem(); // create one item per line
               mItem.setTitle(fileInput.next());
               mItem.setFormat(fileInput.next());
               mItem.setOnLoan(fileInput.nextBoolean());

               String loanedTo = fileInput.next();
               mItem.setLoanedTo(loanedTo != "null" ? loanedTo: null);

               String itemStr = fileInput.next();
               mItem.setDateLoaned(itemStr != "null" ? itemStr : null);

               System.out.println(mItem.getTitle() + " (" + mItem.getFormat() + ") " + mItem.isOnLoan() + 
                       " " + (mItem.isOnLoan() ? mItem.getLoanedTo() : "null") + " "  + 
                       (mItem.isOnLoan() ? mItem.getDateLoaned() : "null")); // Debugging console output

               items.add(mItem);

               System.out.println("Item added: " + mItem.getTitle()); // Debugging console output
               System.out.println("Number of values in Item: " + items.size()); // Debugging console output
           }
           System.out.println("Number of values in Item: " + items.size()); // Debugging console output
       }
   }