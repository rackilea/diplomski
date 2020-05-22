private boolean validateStates(List<ConcessionState> concessionStateList) {
    long startRange,endRange = 0;
    Collections.sort(concessionStateList,
                     Comparator.comparing(ConcessionState::getRangeStart));
    .......
}