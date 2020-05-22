boolean flag = true;
int first = tarningar[0];
for(int i = 1; i < 5 && flag; i++)
{
  if (tarningar[i] != first) flag = false;
}
if (flag) System.out.println("ok");