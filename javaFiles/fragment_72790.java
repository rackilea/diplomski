StringBuilder sb = new StringBuilder();
for (int i = 0; i < movementArray.length; i++)
{
    sb.append(movementArray[i]);
}
setContents(new File("your path here"), sb.toString());