public PatientSelectionWindow(List<PatientData> ptList) {
    this.ptList = ptList;
    model.add(ptList);
    createWindow();
    activePatients();
}