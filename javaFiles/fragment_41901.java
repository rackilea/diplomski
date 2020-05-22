DecimalFormat fmt = new DecimalFormat("0");
fmt.setMaximumIntegerDigits(330);
fmt.setMaximumFractionDigits(330);

System.out.println("0.0123400  = " + 0.0123400               + "   = " + fmt.format(0.0123400));
System.out.println("123400.00  = " + 123400.00                + "  = " + fmt.format(123400.00));
System.out.println("NaN        = " + Double.NaN          + "       = " + fmt.format(Double.NaN));
System.out.println("-INFINITY  = " + Double.NEGATIVE_INFINITY  + " = " + fmt.format(Double.NEGATIVE_INFINITY));
System.out.println("+INFINITY  = " + Double.POSITIVE_INFINITY + "  = " + fmt.format(Double.POSITIVE_INFINITY));
System.out.println("MIN_NORMAL = " + Double.MIN_NORMAL               + " = " + fmt.format(Double.MIN_NORMAL));
System.out.println("MIN_VALUE  = " + Double.MIN_VALUE + "                = " + fmt.format(Double.MIN_VALUE));
System.out.println("MAX_VALUE  = " + Double.MAX_VALUE               + "  = " + fmt.format(Double.MAX_VALUE));