@Test   
public void test()
{
    Stack<Integer> intStack = new Stack<Integer>();
    for(int i = 0; i < 100; i++)        
    {
        intStack.push(i);
    }

    Stack<Integer> copiedStack = (Stack<Integer>)intStack.clone();

    for(int i = 0; i < 100; i++)            
    {
        Assert.assertEquals(intStack.pop(), copiedStack.pop());
    }
}