while (iterator.hasNext())
  {
      Name item = (Name) iterator.next();

      if (item.getFirstName().equals(inputSearch))
      {
          System.out.println("MATCH FOUND: " + item);
      }
  }