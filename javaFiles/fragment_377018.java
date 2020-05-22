String input = "12.4 19.8776 23.3445";
        String[] split = input.split(" ");
        for(String s : split)
        {
            System.out.println(Double.parseDouble(s));
        }