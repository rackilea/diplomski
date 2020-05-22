else if (mChoice.startsWith("4")) {
    System.out.println("What do you want to delete?");

    mChoice = in.nextLine();
    Player deleted;
    if (mChoice.contains("first")) {
       deleted = rBook.mHead.getData();
       rBook.removeFirst();
       System.out.println("Removed first player " + deleted);
    }

    else if (mChoice.contains("last")) {
       deleted = rBook.mHead.mPrev.getData();
       rBook.removeLast();
       System.out.println("Removed last player " + deleted );

    }

    else {
       deleted = rBook.searchByName(mChoice);
       rBook.remove(searchByName(mChoice));
       System.out.println(deleted + " removed.");

    }