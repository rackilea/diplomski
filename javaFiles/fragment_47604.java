for(int i=0,j=0; j<loops && i<length; j++){
        DummyClass dummyClass= new DummyClass ();
        MyHelper.addInMappedElement(i<length?arr[i++].toString():null, value1, dummyClass) ;
        MyHelper.addInMappedElement(i<length?arr[i++].toString():null, value2, dummyClass) ;
        MyHelper.addInMappedElement(i<length?arr[i++].toString():null, value3, dummyClass) ;
        MyHelper.addInMappedElement(i<length?arr[i++].toString():null, value4, dummyClass) ;
    }