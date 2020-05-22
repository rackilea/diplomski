public class Movimento()
{
    ...

    public void paintMe(Graphics g)
    {
        for(int i = 0; i < matriz.length; i++)
        {
            g.drawRect(matriz[i][0],matriz[i][1],1,1);
        }
    }
}