D map(String label) {
        return (D) List.of(values)
                .find(v -> v.getLabel().equals(label))
                .map(LabelAware::getObject)
                .getOrElseThrow(() -> new RuntimeException(""));
    }