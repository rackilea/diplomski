List<Person> personList = new ArrayList<>(…);
…
public XYDataset createDatasets(List<String> personList) {
    XYSeriesCollection seriesColletion = new XYSeriesCollection();
    for (Person person : personList) {
        seriesColletion.addseries(person.getXYSeries());
    }
    return seriesColletion;
}