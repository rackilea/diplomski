GL11.glBegin(GL11.GL_QUADS);
for(int x=0;x<noise.length-1;x++)
{
    for(int y=0;y<noise[x].length-1;y++)
    {
        GL11.glVertex3f(10*x,noise[x][y+1]*10,-10*(y+1));//bottomleft
        GL11.glVertex3f(10*(x+1),noise[x+1][y+1]*10,-10*(y+1));//bottomright
        GL11.glVertex3f(10*(x+1),noise[x+1][y]*10,-10*y);//topright
        GL11.glVertex3f(10*x,noise[x][y]*10,-10*y);//topleft
    }
}
GL11.glEnd();