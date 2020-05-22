public static String arrayToString(String[] args, String sep)
{
StringBuffer buff=new StringBuffer();
for(int i=0; i<args.length; i++) {
    buff.append(args[i]);
    if (i!=args.length-1)
    buff.append(sep);
}

return buff.toString();
}