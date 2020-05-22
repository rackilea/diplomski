ArrayList<String> tokens = new ArrayList<String>();
    String current = "";
    int counter = 0;
    for(int i = 0 ; i < input.length(); i++)
    {
        char c = input.charAt(i);
        if(counter==0 && c=='+')
        {
            tokens.add(current);
            current = "";
            continue;
        }
        else if(c=='(')
        {
            counter++;
        }
        else if(c==')')
        {
            counter--;
        }
        current += c;
    }
    tokens.add(current);