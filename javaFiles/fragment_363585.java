// If we are at the end of input then NoSuchElement;
// If there is still input left then InputMismatch
private void throwFor() {
    skipped = false;
    if ((sourceClosed) && (position == buf.limit()))
        throw new NoSuchElementException();
    else
        throw new InputMismatchException();
}