List<Object[]> hexgenSecurityInferenceData = new ArrayList<Object[]>();
for (String methodName:knowGoodMap.keySet()) {
    hexgenSecurityInferenceData.add(new Object[] {
        knowGoodMap.get(methodName),
        new Object[] {
            methodPropertiesMap.get(methodName),
            methodParametersMap.get(methodName)
        }
     });
 }