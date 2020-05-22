String testCondition = "dontReplace";
        String myString = "Hi, I'm SO";
        String regex = "SO";
        String replacement = "Not SO";

        if(myString.contains(testCondition)){
            myString = myString.replaceAll(regex, replacement); // stays "Hi, I'm SO"
        }

        myString = myString.replaceAll(regex, replacement); // Becomes "Hi, I'm Not SO"