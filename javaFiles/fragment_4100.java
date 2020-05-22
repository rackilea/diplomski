public enum Type {
  TYPE1(1),
  TYPE2(2);

  int code;

  Type(int code){
    this.code = code; 
  }

  public int getCode(){
      return code;
  }
}