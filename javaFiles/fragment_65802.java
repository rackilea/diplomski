for (Map.Entry<LocalVariable, Value> entry : visibleVariables.entrySet()) {
    String name = entry.getKey().name();
    Value value = entry.getValue();

    if (value instanceof ObjectReference) {
        ObjectReference ref = (ObjectReference) value;
        Method toString = ref.referenceType()
                .methodsByName("toString", "()Ljava/lang/String;").get(0);
        try {
            value = ref.invokeMethod(thread, toString, Collections.emptyList(), 0);
        } catch (Exception e) {
            // Handle error
        }
    }

    System.out.println(name + " : " + value);
}