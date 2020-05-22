Duration calculatedTime = Duration.between(startTime, endTime);
    if (calculatedTime.isNegative()) {
        calculatedTime = calculatedTime.plusDays(1);
    }

    System.out.println(calculatedTime);