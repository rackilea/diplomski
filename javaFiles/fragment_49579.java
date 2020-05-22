BiConsumer<String, Float> biConsumer = (key, value) -> {
    if (key.equals("123")) { // preEvalObj
       someOpsOnValue(); // lambda1Onvalue
    } else {
       someOtherOpsOnValue(); // lambda2lambda1Onvalue..
    }
};

someHashMap.forEach(biConsumer);