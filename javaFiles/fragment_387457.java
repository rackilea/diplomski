public void setChosenDataList(List<T> chosen) {
    chosenDataModel.clear();
    chosenDataModel.addAll(chosen);
    candidateModel.removeAll(chosen);
}

@ComponentAnnotation(
        "@ZKBIND(ACCESS=both, SAVE_EVENT=onChoose, LOAD_EVENT=onCreate)")
public List<T> getChosenDataList() {
    return new ArrayList<>(chosenDataModel);
}