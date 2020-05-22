say("Type Done to Finish Inputs");
    String input = "";
    Integer binaryinput;
    List<Object>inputs = new ArrayList<Object>();

    do {
        input = getReq.nextLine();
        //check for binary
        if(input.matches("\\d"))
        {
            binaryinput = Integer.parseInt(input);
            if(binaryinput == 1 || binaryinput == 0)
                inputs.add(binaryinput);
        }
        //check for a single character
        else
        {
            if(input.length() == 1)
                inputs.add(input);  
        }
    } while (!input.equals("done"));