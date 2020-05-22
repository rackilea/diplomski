public void setBricks()
{
    for(int i= 0; i<10;i++)
    {
        for(int a=0; a<5; a++)
        {
            bricks[i][a] = new Rectangle(x+(width*i)+(spacer*i), 5 + a*30, width, height); 
        }                         
    }
}