do{
        Reference<?> ref =  rq.poll();  //this should be your weak reference
        if(ref == null) break;

        ref.get();  //Should always be null, cause referent is gc'd

        // do something

    }while(true);