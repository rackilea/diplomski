public abstract class AbstractMenuScreen extends BaseScreen
{
    protected List<FFButton> buttons;

    public AbstractMenuScreen(List<FFButton> buttons)
    {
        this.buttons = buttons; 
    }

    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        Resources.batch.setProjectionMatrix(Resources.normalProjection);

        Resources.batch.begin();
        for(int i = 0; i < buttons.size(); i++)
        {
            FFButton b = buttons.get(i);
            if(b.isHidden() != true)
            {
                b.drawText(Resources.batch);
            }
        }

        Resources.batch.end();

        Resources.shapeRenderer.setColor(Color.WHITE);
        Resources.shapeRenderer.begin(ShapeType.Line);
        for(int i = 0; i < buttons.size(); i++)
        {
            FFButton b = buttons.get(i);
            if(b.isHidden() != true)
            {
                b.drawBounds(Resources.shapeRenderer);
            }
        }
        Resources.shapeRenderer.end();

        Resources.shapeRenderer.setColor(Color.RED);
        Resources.shapeRenderer.begin(ShapeType.Line);
        for(int i = 0; i < buttons.size(); i++)
        {
            FFButton b = buttons.get(i);
            if(b.isHidden() != true)
            {
                if(b.isActive() == true)
                {
                    b.drawBounds(Resources.shapeRenderer);
                }
            }
        }
        Resources.shapeRenderer.end();

        Resources.shapeRenderer.setColor(Color.MAGENTA);
        Resources.shapeRenderer.begin(ShapeType.Line);
        for(int i = 0; i < buttons.size(); i++)
        {
            FFButton b = buttons.get(i);
            if(b.isHidden() != true)
            {
                if(b.getSelected() == true)
                {
                    b.drawBounds(Resources.shapeRenderer);
                }
            }
        }
        Resources.shapeRenderer.end();
    }

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
        for(int i = 0; i < buttons.size(); i++)
        {
            if(buttons.get(i).contains(pointerX, pointerY))
            {
                if(buttons.get(i).isHidden() != true)
                {
                    buttons.get(i).setSelected(true);
                }
            }
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        float pointerX = InputTransform.getCursorToModelX(windowWidth, screenX);
        float pointerY = InputTransform.getCursorToModelY(windowHeight, screenY);
        for(int i = 0; i < buttons.size(); i++)
        {
            if(buttons.get(i).contains(pointerX, pointerY) && buttons.get(i).getSelected())
            {
                buttons.get(i).execute();
            }
            buttons.get(i).setSelected(false);
        }
        return true;
    }
    ...