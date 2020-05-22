/**
 * @return instance of this as Junit test case
 */
public static junit.framework.Test suite()
{
    return new JUnit4TestAdapter(MyTestClass.class);
}