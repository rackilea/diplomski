if (child.getKey().equals(key))
{
    // This is fine
    return child;
}
else
{
    // This is bad: you ignore the return value.
    getNode(key, child.getChildren());
}