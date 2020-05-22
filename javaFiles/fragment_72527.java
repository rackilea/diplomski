double avgTemperature = 
    temp.stream()
        .filter(o -> o != null && o.getTemperature() != null)
        .mapToDouble(EnvironmentData::getTemperature)
        .average()
        .orElse(0.0);