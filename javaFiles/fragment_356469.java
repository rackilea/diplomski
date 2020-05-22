@Override
public String toString()
{
    StringBuilder sb = new StringBuilder();
    sb.append("Car Make: ");
    sb.append(cm);
    sb.append("\n");   //You can use System.getProperty("line.separator") if you want to make it platform independent 
    sb.append("Car colour: ");
    sb.append(col);
    //You can append as many details of your class car this way.
    //and finally just return the StringBuilder as String. 
    return sb.toString();
}