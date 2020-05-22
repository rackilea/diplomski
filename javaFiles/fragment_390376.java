public boolean gHappy(String str) {
boolean flag = true;
if(str == "") return flag;

if(str.length() <= 2 && !str.equals("gg")) {
return false;
}

for(int i = 1; i < str.length()-1; i++)
{
  if(str.charAt(i) == 'g')
  {
    if(!(str.charAt(i-1) == 'g' || str.charAt(i+1) == 'g'))
    {
      flag = false;
      break;
    }
  }
  else if((i == str.length()-2) && (str.charAt(i+1) == 'g') && 
  (str.charAt(i) != 'g'))
  {
     flag = false;
     break;
  }
  }
  return flag;
  }