public EHandled function1(List<Integer> inList1, List<String> inList2)
{  
    // remove the need for null checks
    List<Integer> list1 = (inList1 != null ? inList1 : Collections.emptyList());
    List<String> list2 = (inList2 != null ? inList2 : Collections.emptyList());

    // if there are too many entries, then leave; this handles
    // cases of either list having > 1 element, or both lists having
    // >= 1 element
    if (! validNumberOfEntries(list1, list2)) {
        return EHandled.NONE;
    }

    if (list1.size() == 1) {
        return doSomethingWithIntList(list1);
    }
    else if (list2.size() == 1) {
        return doSomethingWithStringList(list2);
    }
    else {
        // should never happen; could also be handled by an assert
        System.err.println("Something wicked this way comes");
        return EHandled.ERROR;
    }
}


/**
 * If the total of the two lists is > 1, then there are too many entries;
 * if the total == 0, there are not enough
 * @param list1 A non-null list
 * @param list2 A non-null list
 */
public boolean validNumberOfEntries(List<Integer> list1, List<String> list2)
{
    int s1 = list1.size();
    int s2 = list2.size();
    return (s1 + s2 == 1);
}


public EHandled doSomethingWithIntList(List<Integer> list)
{
    System.out.println("Processing Integers");
    for (Integer i : list) {
        System.out.println(i);
    }

    return EHandled.INTEGERS;
}

public EHandled doSomethingWithStringList(List<String> list)
{
    System.out.println("Processing Strings");
    for (String s : list) {
        System.out.println(s);
    }
    return EHandled.STRINGS;
}

private enum EHandled
{
    NONE,
    INTEGERS,
    STRINGS,
    ERROR,
}