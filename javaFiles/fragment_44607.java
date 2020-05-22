private static Jframe openFrame;
...
...
if (openFrame != null)
{
    openFrame.dispose();
}

openFrame = this;