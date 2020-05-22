for(int index = 0; i < object3.size(); i++)
{
   if(object3.get(i).getName().equals(str3) && object3.get(i).getDepartment().equals(str4))
   {
      object3.remove(index);
      break;
   }
}