T previous = null;
// If it makes sense to skip the first "null, first element" pair...
if (it.hasNext())
{
    previous = it.next();
}    

while (it.hasNext())
{
    T current = it.next();
    // Process previous and current here.

    // End of loop, after processing.  Maintain previous reference.
    previous = current;
}