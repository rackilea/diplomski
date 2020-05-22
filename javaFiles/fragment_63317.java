public Map getMapFromPojo(InitialAssessment assessment) throws Exception {
    Map<String, Object> map = new HashMap<>();

    if (assessment != null) {
        Method[] methods = assessment.getClass().getMethods();

        for (Method method : methods) {
            String name = method.getName();

            if (name.startsWith("get") && !name.equalsIgnoreCase("getClass")) {
                Object value = "";

                try {
                    value =  method.invoke(assessment);
                    map.put(name.substring(name.indexOf("get") + 3), value);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return map;
    }

    return null;
}