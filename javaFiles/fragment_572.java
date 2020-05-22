Object[] args = new Object[paramsExpected.length];
    int i = 0;  
    for( Class<?> param: paramsExpected) {
        args[i] = convertStringToType(paramsActual[i], param);
        i  = i +1;
    }
    method.invoke(context, args);

    Object convertStringToType(String input, Class<?> type) {
      return ConverterUtils.convert(input,type);
    }