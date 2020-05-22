for(int i = 0; i < names.size(); i++){


        int x = valueOfName(names.get(i));
        mult = x * (i + 1); //Was missing "+1" because index starts at 0

        bigSum += mult;

    }