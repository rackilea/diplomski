//STORING FACTORIAL COMPUTATIONS
    private Map<Integer,Long> factorialMap = new HashMap<Integer,Long>();


    public Long getFactorial(int number) {

        //CHECK IF I ALREADY COMPUTED THIS FACTORIAL
        Long val = factorialMap.get(number);
        if(val != null) {
            //GOT IT!
            return val;
        } else {
            //NEED TO COMPUTE!
            val = getFactorialRecursive(number);
            //STORING IT TO SAVE COMPUTATION FOR LATER
            factorialMap.put(number, val);
            return val;
        }
    }

    //RECURSIVE FUNCTION TO COMPUTE FACTORIAL
    public Long getFactorialRecursive(int number) {
        if(number < 2) {
            return 1L;
        } else {
            return number * getFactorialRecursive(number-1);
        }
    }


    //ACTUAL CALL TO "20 choose 5"
    public Long combination(int fromVal, int chooseVal) {
        return getFactorial(fromVal)/(getFactorial(chooseVal)*getFactorial(fromVal-chooseVal));
    }