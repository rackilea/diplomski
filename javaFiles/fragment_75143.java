switch (OPERATION_TYPE) {
   case TYPE_1:
      typeOne();
   case TYPE_2:
      typeTwo();
}

private void typeOne()
{
    IOperation<Type1> parameter1 = new MyOperation<>();
    ITotallyDifferentOperation<Type1> parameter2 = new MyTotallyDifferentOperation<>();

    doTheChecks(parameter1, parameter2);
    databaseStuff(parameter1, parameter2);
}

private void typeTwo() /*identical to above, except the types*/
{
    IOperation<Type2> parameter1 = new MyOperation<>();
    ITotallyDifferentOperation<Type2> parameter2 = new MyTotallyDifferentOperation<>();

    doTheChecks(parameter1, parameter2);
    databaseStuff(parameter1, parameter2);
}

<T> void doTheChecks(IOperation<T> param1, ITotallyDifferentOperation<T> param2)
{
    ...
}

<T> void databaseStuff(IOperation<T> param1, ITotallyDifferentOperation<T> param2)
{
    switch (DB_OPERATION_TYPE) {
        case DB_TYPE_1:
            myMethod(param1, param2);
            break;
        case DB_TYPE_2:
            myOtherMethod(param1, param2);
            break;
    }
}