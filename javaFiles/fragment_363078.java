for(int i = 0; i < CharArr.length; i++) {

        double subtract = DoubleArr[i];
        if (randomDouble - subtract <= 0.0) {
             retVal = CharArr[i];
             break;
        }
        else
            randomDouble -= subtract;
    }