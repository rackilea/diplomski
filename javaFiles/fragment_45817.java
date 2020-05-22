Map<String, Patient> map = 
getValute().stream().collect(
    Collectors.groupingBy(
        Patient::getName,
        Collectors.collectingAndThen(
            Collectors.toList(), 
            values -> values.get(0))));