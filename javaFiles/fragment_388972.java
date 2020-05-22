public boolean canConstruct(Object[] args, Constructor<?> c){
        Class<?>[] paramTypes = c.getParameterTypes(); 
        if(args.length != paramTypes.length){
            return false;
        }

        int i = 0;
        for(Object arg: args){
            if(!paramTypes[i].isAssignableFrom(arg.getClass())){
                return false;
            }
                    i++;
        }

        return true;
    }