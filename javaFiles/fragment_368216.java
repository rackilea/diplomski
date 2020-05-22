itemnum = kbd.nextInt();
    while (itemnum == 0) {
      try{
        item = store.find(itemnum);

          if (item != null) {
             System.out.print(itemnum);
          } 
        } catch (ItemNotFound e){
            System.out.println(" Item  was not found with id :"+ itemnum);
        }
        System.out.println();
        System.out.print("Player (0 to exit)? ");
        itemnum = kbd.nextInt();
    }