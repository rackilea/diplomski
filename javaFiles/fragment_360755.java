public abstract class FFButton 
{
    private Rectangle bounds;
    private CharSequence text;
    private boolean selected;
    private boolean hidden;
    private boolean active;
    private boolean disabled;

    public FFButton(Rectangle bounds, CharSequence text)
    {
        this.bounds = bounds;
        this.text = text;
        this.hidden = false;
        this.active = false;
        this.disabled = false;
    }

    protected abstract void action();

    public void execute()
    {
        if(disabled == false)
        {
            action();
        }
    }


    public boolean contains(float x, float y)
    {
        return bounds.contains(x, y);
    }

    public float x()
    {
        return bounds.x;
    }

    public float y()
    {
        return bounds.y;
    }

    public float width()
    {
        return bounds.width;
    }

    public float height()
    {
        return bounds.height;
    }

    public void drawBounds(ShapeRenderer shapeRenderer)
    {
        if(hidden != true)
        {
        shapeRenderer.rect(x(), y(), width(), height(), 0, 0, 0);
        }
    }

    public CharSequence getText()
    {
        return text;
    }

    public FFButton setText(String text)
    {
        this.text = text;
        return this;
    }

    public void drawText(SpriteBatch batch)
    {
        if(hidden != true)
        {
            Resources.bitmapFont.draw(batch, getText(), x()+(width()/8), y()+height()*0.75f); //black magic, please adjust
        }
    }

    public boolean getSelected()
    {
        return selected;
    }

    public FFButton setSelected(boolean selected)
    {
        this.selected = selected;
        return this;
    }

    public boolean isActive()
    {
        return active;
    }

    public FFButton setActive(boolean active)
    { 
        this.active = active;
        return this;
    }

    public boolean isHidden()
    {
        return hidden;
    }

    public FFButton setHidden(boolean hidden)
    {
        this.hidden = hidden;
        return this;
    }

    public Rectangle getBounds()
    {
        return bounds;
    }

    public boolean isDisabled()
    {
        return disabled;
    }

    public void setDisabled(boolean disabled)
    {
        this.disabled = disabled;
    }
}