for(int i=0;i<names.length;i++){
      if(input.nextLine().equals("")){
          System.out.println("Enter students name : ");
          names[i] = input.nextLine();
      }
      System.out.println("Enter the student scores : ");
      scores[i]=input.nextDouble();
  }