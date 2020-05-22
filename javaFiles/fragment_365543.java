class CSVParsingBuilder<T> implements IParsableBuilder<T, CSVCriteriaBuilder<T>>{

    CSVCriteriaBuilder<T> criteriaBuilder;

    @Override
    public void setCriteria(CSVCriteriaBuilder<T> criteriaBuilder) {
        this.criteriaBuilder=criteriaBuilder;
    }
    ....
}