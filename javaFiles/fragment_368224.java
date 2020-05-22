Body c;
            if(a.getUserData() instanceof RunnerUserData) c = a;
            else c = b; //checks which body is a runner
            for (Runner r : runners){
                if(r.getUserData() == c.getUserData()){
                    runners.remove(r); 
                    break; //do something if you detect proper runner and quit the loop
                }
            }