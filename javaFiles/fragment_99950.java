public GameScreen implements Screen, InputProcessor
{

  @Override
  public void show()
  {
      Gdx.input.setInputProcessor(this);
  }

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button)
  {
      float pointerX = InputTransform.getCursorToModelX(windowWidth, screenX);
      float pointerY = InputTransform.getCursorToModelY(windowHeight, screenY);
      for(int i = 0; i < balloons.size(); i++)
      {
          if(balloons.get(i).contains(pointerX, pointerY))
          {
              balloons.get(i).setSelected(true);
          }
      }
      return true;
   }

   @Override
   public boolean touchUp(int screenX, int screenY, int pointer, int button)
   {
       float pointerX = InputTransform.getCursorToModelX(windowWidth, screenX);
       float pointerY = InputTransform.getCursorToModelY(windowHeight, screenY);
       for(int i = 0; i < balloons.size(); i++)
       {
           if(balloons.get(i).contains(pointerX, pointerY) && balloons.get(i).getSelected())
           {
               balloons.get(i).execute();
           }
           balloons.get(i).setSelected(false);
       }
       return true;
    }

public class InputTransform
{
    private static int appWidth = 480;
    private static int appHeight = 320;

    public static float getCursorToModelX(int screenX, int cursorX) 
    {
        return (((float)cursorX) * appWidth) / ((float)screenX); 
    }

    public static float getCursorToModelY(int screenY, int cursorY) 
    {
        return ((float)(screenY - cursorY)) * appHeight / ((float)screenY) ; 
    }
}