public static final DecimalFormat DF = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);

static {
    DF.setMaximumFractionDigits(16);
    DF.setGroupingUsed(false);
}

public static double fixedSignificantDigitIncrement(double input, int significantDigit){
    return input+fixedSignificantDigitAmount(input, significantDigit);
}

public static double fixedSignificantDigitDecrement(double input, int significantDigit){
    return input-fixedSignificantDigitAmount(input, significantDigit);
}

public static double fixedSignificantDigitAmount(double input, int significantDigit){
    String inputStr = DF.format(input);

    int pointIndex = inputStr.indexOf('.');

    int digitsBeforePoint;
    if(pointIndex==-1){
        pointIndex=inputStr.length();
        digitsBeforePoint=inputStr.length();
    } else {
        digitsBeforePoint = pointIndex;
        if(digitsBeforePoint==1 && inputStr.charAt(0)=='0') digitsBeforePoint=0;
    }

    if(significantDigit<=digitsBeforePoint){
        return Math.pow(10, digitsBeforePoint-significantDigit);
    }  else if(digitsBeforePoint==0){
        ++pointIndex;
        for(;pointIndex<inputStr.length();pointIndex++){
            if(inputStr.charAt(pointIndex)!='0') break;
        }

        return 1/Math.pow(10, significantDigit+(pointIndex-2));
    }

    return 1/Math.pow(10, significantDigit-digitsBeforePoint);
}