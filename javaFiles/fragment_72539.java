private Optional<String> locatedTitle(MovieEntity movieEntity) {
  return movieEntity.getOtherTitles().stream()
    .filter(ot -> ot.getStatus() == DataStatus.ACCEPTED)
    .map(ServiceUtils::toOtherTitleDto)
    .filter(ot -> ot.getCountry() != null
        && ot.getCountry().getCode().equals(Locale.getDefault().getCountry()))
    .map(OtherTitle::getTitle)
    .findFirst();
}