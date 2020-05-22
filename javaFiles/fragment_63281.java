public void run()
{
    while (running)
    {
        if (!showtails)
        {
            obj.setColor(Color.white);
            obj.clearRect(currentlocation.x,currentlocation.y,size+5,size+5);
        }
        update();
        draw(obj);
        pause();
        move();
    }
}