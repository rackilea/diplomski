String fileLine;
while((fileLine = br.readLine()) != null)
    {
        temp = fileLine.trim();
        if (temp.startsWith(input))
        {
            String[] splitted = temp.split("=");
            output += splitted[1] + "\n";
        }
    }