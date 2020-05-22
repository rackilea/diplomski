public Map<String, Map<String, List<String>>> findCropDetails() {
    List<CropDetailDto> cropdetails = cropRepository.getCropDetails();
    return cropdetails.stream().collect(Collectors.groupingBy(CropDetailDto::getCropName,
            Collectors.groupingBy(v -> v.getVarietyName() == null ? "undefined" : v.getVarietyName(),
                    Collectors.mapping(m -> m.getSubVarietyName() == null ? "undefined" : m.getSubVarietyName(),
                            Collectors.toList()))));
}