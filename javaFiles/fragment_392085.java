private methodTwo methodTwoInMethodThree;
 private methodOne methodOneInMethodThree;

@Override
public String toString()
{
    StringBulder sb = new StringBuilder();
    if(this.methodTwoInMethodThree != null)
    {
         sb.append("Method 2:").append(methodTwoInMethodThree.toString());
    }

    if(methodOneInMethodThree != null)
    {
        sb.append("Method 1:").append(methodOneInMethodThree.toString());
    }  

    return sb.toString();
}