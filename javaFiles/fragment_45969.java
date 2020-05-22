public void doSomethingToAll(List list)
{
    // Begin the recursion.
    doSomethingToAll(list, 0);
}

private void doSomethingToAll(List list, int index)
{
    // Break the recursion when we have processed the entire list.
    if (index >= list.size()) return;

    // Do whatever you want with the list.
    process(list.get(index));

    // Recursive step. Process the next element.
    doSomethingToAll(list, index + 1);
}