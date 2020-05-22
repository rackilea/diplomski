final Font f = new Font(...);
for (char c = 0x0000; c <= 0xFFFF; c++)
{
  if (f.canDisplay(c))
  {
    // draw it ...
  }
}