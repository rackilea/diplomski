//public

ClassOne instance = new ClassOne();

ClassTwo instante2 = new ClassTwo();

instance2.myNewInt = instance.myNum;

//public static

ClassTwo instante2 = new ClassTwo();

instance2.myNewInt = ClassOne.myNum;

//getter

 ClassOne instance = new ClassOne();

 ClassTwo instante2 = new ClassTwo();

 instance2.myNewInt = instance.getMyNum();

 //and inside of ClassOne you'll have

  private int MyNum = 5;

  public getMyNum(){

     return MyNum;  

  }