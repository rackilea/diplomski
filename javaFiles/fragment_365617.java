public class ProgressBar extends UIitem {

    public Sprite sprite,sprite2;
    public boolean visible=true;


    //texture is the progress bar (the one that decreases and background is the background texture of the progress bar
    public ProgressBar(float x, float y, float sizex, float sizey, Texture texture,Texture background) {
        pos = new Vector(x, y);
        size = new Vector(sizex, sizey);
        sprite = new Sprite(texture);
        sprite2 = new Sprite(background);
        color = new gColor(1, 1, 1, 1);
    }

    float timeon=0;

    float progress,orogressMb;
    public float getProgress() {
        return orogressMb;
    }
    public void setProgress(float p){
        orogressMb=p;
        if(orogressMb>1)orogressMb=1;
        else if(orogressMb<0)orogressMb=0;
    }

    @Override
    public void Render(SpriteBatch sb) {
        if(!visible)return;

        sprite2.setColor(color.r, color.g, color.b, color.a);
        sprite2.setRotation(0);
        sprite2.setPosition(getPos().x - getSize().x * scaleup / 2, getPos().y- getSize().y * scaleup / 2);
        sprite2.setSize(getSize().x * scaleup, getSize().y * scaleup);
        sprite2.setOrigin((getSize().x * scaleup) / 2,(getSize().y * scaleup) / 2);
        sprite2.draw(sb);

        sprite.setColor(color.r, color.g, color.b, color.a);
        sprite.setRotation(0);
        sprite.setRegion(0, 0, progress, 1);
        sprite.setSize((getSize().x * scaleup)*progress, getSize().y * scaleup);
        sprite.setPosition(getPos().x-getSize().x/2, getPos().y- getSize().y * scaleup / 2);
        sprite.setOrigin((getSize().x * scaleup) / 2,(getSize().y * scaleup) / 2);
        sprite.draw(sb);

        timeon+=Gdx.graphics.getDeltaTime();
        if(timeon>0.5f){
            progress+=((orogressMb-progress)/10)*Director.delta;
        }
    }

}