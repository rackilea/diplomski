Type refClass = refChildNode.GetType();
Type testClass = testChildNode.GetType();
if (!refClass.Equals(testClass)) 
{
    ....
}