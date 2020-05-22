String xStr = "xuyx";

int index = xStr.indexOf("x", 0);
while(index >= 0)
{
  System.out.println(index);
  index = xStr.indexOf("x", index + 1);
}