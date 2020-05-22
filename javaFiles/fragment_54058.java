public class DifferenceCriterion implements Criterion{

    private static final long serialVersionUID = -8082375591482621375L;

    private String firstProperty;
    private String secondProperty;
    private int value;

    public DifferenceCriterion(String propertyA, String propertyB, int value) {
        this.firstProperty = propertyA;
        this.secondProperty = propertyB;
        this.value = value;
    }

    @Override
    public TypedValue[] getTypedValues(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
        TypedValue tvFirst = criteriaQuery.getTypedValue(criteria, firstProperty, value);
        TypedValue tvSecond = criteriaQuery.getTypedValue(criteria, secondProperty, value);
        if(!tvFirst.equals(tvSecond)){
            throw new HibernateException("Properties typedValues are not the same!");
        }
        return new TypedValue[] {tvFirst};
    }

    @Override
    public String toSqlString(Criteria criteria, CriteriaQuery criteriaQuery) throws HibernateException {
        final String[] columnsA = criteriaQuery.getColumnsUsingProjection(criteria, this.firstProperty);
        final String[] columnsB = criteriaQuery.getColumnsUsingProjection(criteria, this.secondProperty);
        return columnsA[0] + " - "+columnsB[0] + " >  ?";
    }
}