class test implements Comparable<test>
{
    int id;
    String name;
    public test(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(test o) {
        if(this.id>o.id)
            return 1;
        else if(this.id==o.id)
            return 0;
        else
            return -1;

    }

    @Override
    public boolean equals(Object o) {
      if (o == null) 
        return false;
      if(!this.getClass().equals(o.getClass()) 
        return false;

      test that = (test) o;
      return this.compareTo(that) == 0;
    }

    @Override
    public int hashCode() { return id; }
}