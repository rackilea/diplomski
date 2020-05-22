class MyClass { 
  private static entity character = new entity(); //class variable!
  public static void clip(){
      while(!Display.isCloseRequested()){
          glClear(GL_COLOR_BUFFER_BIT);

          if(character.gravity)character.y++; 
          Display.update();
          Display.sync(70);
      }
  }

  public static void initGame(){
      character = new entity(); // it will 'reset' game and bind a new object to the class variable `character`.
      character.create(true, "box", true);
  }
}