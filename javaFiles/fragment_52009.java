List<Labels> dbRecord = roleRecord.getLabels();
        List<Labels> userRecord = role.getLabels();

        Map<String, Labels> labelsByName = dbRecord.stream()
            .collect(Collectors.toMap(this::getCorrectedLabelName, i -> i));

        userRecord.stream()
            .filter(label -> labelsByName.containsKey(getCorrectedLabelName(label)))
            .forEach(label -> labelsByName.put(getCorrectedLabelName(label), label));

        Collection<Labels> updatedLabels = labelsByName.values();