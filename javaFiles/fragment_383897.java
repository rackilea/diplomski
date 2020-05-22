linenum = 1;
while (scan.hasNextLine())
{
    String line = scan.nextLine();
    if ((linenum % 4) > 0)
    {
        StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
        ... blah
    }

    ++linenum;
}