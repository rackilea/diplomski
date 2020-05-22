public int getIntParameter(String strParamval){

        int nRetVal=0;
        if((strParamval != null) && (!strParamval.matches("\\d*")))
            return nRetVal;
        try{
            nRetVal = Integer.parseInt(strParamval);
        }catch(NumberFormatException nfe){
        }
        return nRetVal;
    }