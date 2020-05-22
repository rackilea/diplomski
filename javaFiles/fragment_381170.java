public class MockFactory {
    public static <D extends BaseDao,M> D mockDao(Class<D> daoClass, Class<M> modelClass) {
        D dao = mock(daoClass);
        M model = mock(modelClass);
        when(dao.findByDescription(anyString())).thenReturn(model));
        return dao;
    }

    public static Csv csvWithOneRecord() {
        RowFromCsv row = mock(RowFromCsv.class);
        when(row.getAttribute1()).thenReturn(new DateTime()); 
        when(row.getAttribute2()).thenReturn(new DateTime());
        Csv csv = mock(Csv.class);
        when(csv.next()).thenReturn(row).thenReturn(null);
    }
}