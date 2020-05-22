class Test<T> {
  int num;
  public T obj;

  public Test(int num, T obj){
    this.num = num;
    this.obj = obj;
  }

  int getNum(){
    return num;
  }

}

class Bird {
  public int size;

  public Bird(int size){
    this.size = size;
  }

  public void setSize(int size){
    this.size = size;
  }

  public int getSize(){
    return size;
  }

}
void setup(){
   size(100, 100);

   Bird y = new Bird(7);
   Test<Bird> x = new Test<>(4, y);
}