public Map<String, Map<String, List<String>>> findCropDetails() {
    List<CropDetailDto> cropdetails = cropRepository.getCropDetails();
    return cropdetails.stream().collect(Collectors.groupingBy(CropDetailDto::getCropName,
            Collectors.filtering(v -> v.getVarietyName() != null, Collectors.groupingBy(CropDetailDto::getVarietyName,
                    Collectors.filtering(m -> m.getSubVarietyName() != null, Collectors.mapping(CropDetailDto::getSubVarietyName,
                            Collectors.toList()))))));
}