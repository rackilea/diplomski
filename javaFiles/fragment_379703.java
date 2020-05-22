Comparator<MyClass> comparator = Comparator.nullsFirst(Comparator.comparing((MyClass myClass) -> !isActive(myClass))
    .thenComparing((MyClass myClass) -> isActive(myClass) ? myClass.startDate : myClass.endDate, Comparator.nullsFirst(DateTimeComparator.getInstance())));

private static boolean isActive(MyClass myClass)
{
    switch (myClass.state)
    {
    case "OPEN":
    case "PENDING":
    case "RUNNING":
        return true;
    default:
        return false;
    }
}