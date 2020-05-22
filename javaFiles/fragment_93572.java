// For now, if a bigint is going to be cast to a double throw an error or warning
      if ((oiTypeInfo0.equals(TypeInfoFactory.stringTypeInfo) && oiTypeInfo1.equals(TypeInfoFactory.longTypeInfo)) ||
          (oiTypeInfo0.equals(TypeInfoFactory.longTypeInfo) && oiTypeInfo1.equals(TypeInfoFactory.stringTypeInfo))) {
        String error = StrictChecks.checkTypeSafety(conf);
        if (error != null) throw new UDFArgumentException(error);
        console.printError("WARNING: Comparing a bigint and a string may result in a loss of precision.");
      } else if ((oiTypeInfo0.equals(TypeInfoFactory.doubleTypeInfo) && oiTypeInfo1.equals(TypeInfoFactory.longTypeInfo)) ||
          (oiTypeInfo0.equals(TypeInfoFactory.longTypeInfo) && oiTypeInfo1.equals(TypeInfoFactory.doubleTypeInfo))) {
        String error = StrictChecks.checkTypeSafety(conf);
        if (error != null) throw new UDFArgumentException(error);
        console.printError("WARNING: Comparing a bigint and a double may result in a loss of precision.");
      }