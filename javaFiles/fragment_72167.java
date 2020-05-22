int virtFunIndex=-1;
        boolean found=false;
        while(found==false){
            ++virtFunIndex;
            try{ 
                int id=cp.isMember("org.javadynamicanalyzer.MethodStackEntry", "setBlockIndex", virtFunIndex);
                if(id!=0){
                    found=true;
                }
            }
            catch(NullPointerException | ClassCastException e){}
        }