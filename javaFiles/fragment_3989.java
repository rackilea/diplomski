public List<Data> process(Data one, Data two) //pseudo code
  {
     List<Data> result = new List<>();
     for(Row row : one)
     {
       Id id = row.getId();
       Row additional = two.lookup(id);
       if(additional != null)
         merge(row, additional);

       result.add(row);
     }
  }

  public void merge(Row a, Row b)
  {
    //Your logic here.... either mutating or returning a copy.
  }