if (input.equals("1")){
         System.out.println("Input new book: ");
         input = reader.nextLine();
         Book booka = new Book(); // add this
         booka.setName(input);
         books.add(booka); input ="1";
    }