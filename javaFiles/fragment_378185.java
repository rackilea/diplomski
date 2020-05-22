private void throwFor() {
    skipped = false;
    if ((sourceClosed) && (position == buf.limit()))
        throw new NoSuchElementException();
    else
        throw new InputMismatchException();
}