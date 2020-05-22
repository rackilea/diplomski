Color color[]={Color.YELLOW,Color.MAGENTA,Color.BLACK,new Color(0x964B00),new Color(0xB57EDC)};

// remember the previous color somehow
int previousColorIndex = 0;

// -----

newColorIndex = randomExclude(previousColorIndex)

myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = color[newColorIndex];
myPanel.repaint();

previousColorIndex = newColorIndex

// -----

public static int randomExclude(int previous)
{
  Random rand=new Random();
  int random =rand.nextInt(5);

  if(previous == random)
    {
        return randomExclude(previous);
    } 
  }

  return random;
}