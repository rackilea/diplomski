interpreter = new JeksInterpreter() {

      @Override
      public Object getBinaryOperatorValue (Object binaryOperatorKey, Object param1, Object param2)
      {
        // Only functions may take a cell set as parameter
        if ( param1 instanceof JeksCellSet || param2 instanceof JeksCellSet)
          throw new IllegalArgumentException ();
        // Enabled comparison between any type supported by Jeks
        else if (binaryOperatorKey.equals (JeksExpressionSyntax.OPERATOR_EQUAL))
          return param1 != null && param1.equals (param2)
                   ? Boolean.TRUE : Boolean.FALSE;
        // Enabled comparison between any type supported by Jeks
        else if (binaryOperatorKey.equals (JeksExpressionSyntax.OPERATOR_DIFFERENT))
          return param1 != null && param1.equals (param2) ? Boolean.FALSE : Boolean.TRUE;
        else
          return super.getBinaryOperatorValue (binaryOperatorKey, param1, param2);
      }
    };

    parser = new ExpressionParser(new JeksExpressionSyntax(), null);