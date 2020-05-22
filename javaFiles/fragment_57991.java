else
        {
            char temp = text.get(textVal + nullValue - 1);
            output.add(temp);
            textVal = nextWord(textVal);
        }