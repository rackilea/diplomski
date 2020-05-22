// This method receive a variable which can help me know which type of instance he want
    public String getInstanceStr(JoinPoint joinPoint, Class<? extends Object> clazz){
        String requestStr = null;
        Object[] os = joinPoint.getArgs();
        for (int i = 0; i < os.length; i++) {
            /*?How to determine the type here?*/
             if(clazz.isInstance(os[i])){
                requestStr = os[i].toString();
            }

        }
        return requestStr;
    }