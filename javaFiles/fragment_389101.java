for(int x = 0; x < list.size(); x++)
{
     Object currentObject = list.get(x);
     table[x][0] = currentObject.getValue();
     // Load the first value.
     ...
     table[x][2] = currentObject.getYorN().equalsIgnoreCase("Y")? true:false;
     // Embed a selection statement to decide if to store true or false.
}