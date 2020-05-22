public Long getClasses (List<Classes> classes){


            for(int i=0;i <classes.size(); i++){
                if(classes.get(i).classes().size()>0){
                    //Change is here
                    return getClasses(classes.get(i).getClasses());
                }else{
                  return classes.get(i).getIndexValue();
                }
            }
            return null;
        }