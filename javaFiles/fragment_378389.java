public MyEntity
{
  private Object identity;
  private long mutated;
  private Data data;

  public MyEntity(Object identity, long mutated, Data data)
  {
    this.identity = identity;
    this.mutated= mutated;
    this.data = data;        
  }

  public Object getIdentity()
  {
    return this.identity;
  }

  public Data getData()
  {
    return this.data;
  }

  public Builder copy()
  {
    return new Builder();
  }

  public class Builder
  {
    private Data data = MyEntity.this.data;

    public Builder setData(Data data)
    {
      this.data = data;  
    }

    public MyEntity build()
    {
      return new MyEntity(MyEntity.this.identity, MyEntity.this.mutated, this.data);
    }
  }
}