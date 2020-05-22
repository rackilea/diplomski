private Optional<CPBTuple> getTuple(Collection<ConsignmentAlert> alertsOnCpdDay) {
    return alertsOnCpdDay.stream()
                  .flatMap(s-> s.getAlertActions().stream())
                  .map(s-> handleAlertAction(reportDTO, consignmentId, s))
                  .filter(s-> s.isPresent())
                  .findFirst();
}