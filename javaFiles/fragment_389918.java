public void update(GameContainer gc, int delta)  throws SlickException     
{
Input input = gc.getInput();
//here you should create a collection of all the keys you're interested to check
Integer[] collection = {Input.KEY_C, Input.KEY_B, Input.KEY_A};
for (Integer key: collection)
{
  if (input.isKeyPressed(key))
  {
  char c = input.getKeyName(int code);
  addChar(char c);
  }
}