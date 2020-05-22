private String methodInMainClass(Object someRef){
      String[] returnedValue= {""};

      new SomeInnerClass(someRef){
          @Override
          public String getData(Object value){
              if(value instanceof MyXYZClass){
                  returnedValue[0] = ((MyXYZClass)value).toString(); // Not Happening. I cannot assign it to the outer variable.
              }
              return super.getData(value);
          }
    }
    // [...]