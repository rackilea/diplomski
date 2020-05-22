void unknownProgress(IProgressMonitor monitor)
{
    SubMonitor subMonitor = SubMonitor.convert(monitor);
    while (hasMore())
     {
        // Use 1% of the remaining space for each iteration
        processNext(subMonitor.setWorkRemaining(100).split(1));
     }
}