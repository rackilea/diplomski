String encode(String in, ArrayList<String> a, ArrayList<String> b) //in is lowercase
{
    in = in.toUpperCase();
    for(int i = 0; i < a.size(); i++)
        in = in.replaceAll(a.get(i).toUpperCase(), b.get(i));
    return in;
}