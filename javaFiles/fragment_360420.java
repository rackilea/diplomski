public void checkRecursive()
{
    boolean condition = checkCondition(); 

    if (base_condition_to_avoid_recursion)
        return;

    if (condition)
    {
        if (some other condition A)
        {
            checkRecursive();
        }
        else if (some other condition B)
        {
            call_method_B();
        }
        else
        {
            call_method_C();
        }
    }
    else
    {
        call_method_D();
    }
}