grammar test;

@members {
  private int count = 0;
  private int names = 0;
}

file
    : count (name)+
      {
        if (count != names) throw new Exception("");
      }
    ;

count
    : 'NameCount' EQ Number
      {
        count = Integer.parseInt($Number.text);
      }
    ;

name
    : 'Name' EQ Value
      {
        names++;
      }
...