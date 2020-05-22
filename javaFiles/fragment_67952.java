public class ClassWithLongMethod {
    private DataSourceOne dataSourceOne;
    private DataSourceTwo dataSourceTwo;

    public ClassWithLongMethod(DataSourceOne dataSourceOne,
                               DataSourceTwo dataSourceTwo) {
        this.dataSourceOne = dataSourceOne;
        this.dataSourceTwo = dataSourceTwo;
    }

    public Result longMethod() {
        someData = dataSourceOne.getData();
        someMoreData = dataSourceTwo.getData();
        ...
        return result;
    }
}