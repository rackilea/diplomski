public String toString(List<String> strings)
{
    StringBuilder sb = new StringBuilder();

    for(String s:strings)
    {
        sb.append(" "+s);
    }

    return sb.toString();
}