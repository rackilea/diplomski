someHashMap.forEach((key, value) -> {
    if (preEvalObj.equals(key)) {
        someOpsOnValue(); // lambda1Onvalue
    } else {
        someOtherOpsOnValue(); // lambda2lambda1Onvalue
    }
});