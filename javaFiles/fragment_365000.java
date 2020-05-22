String str = "a| b |c& d^ e|f";
String regex = "\\b\\s*";
String[] spts = str.split(regex);
    for(int i =0; i < spts.length && i < 20; i++)
    {
        System.out.println(spts[i]);
    }