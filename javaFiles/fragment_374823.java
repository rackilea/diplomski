while (true)
{
    // this blocks
    ObjectX referenceObj = refQ.remove().get();
    cancelFutures( referenceObj );
}