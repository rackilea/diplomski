@Test
public void test()
{
    Stack<Integer> intStack = new Stack<Integer>();
    for(int i = 0; i < 100; i++)
    {
        intStack.push(i);
    }

    //No warning
    Stack<?> copiedStack = (Stack<?>)intStack.clone();

    for(int i = 0; i < 100; i++)
    {
        Integer value = (Integer)copiedStack.pop(); //Won't cause a warning, no matter to which type you cast (String, Float...), but will throw ClassCastException at runtime if the type is wrong
        Assert.assertEquals(intStack.pop(), value);
    }
}