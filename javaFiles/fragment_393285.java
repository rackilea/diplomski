@Override
public void close() throws ItemStreamException {
   delegate.close();
}

@Override
public void open(ExecutionContext arg0) throws ItemStreamException {
    delegate.open(arg0);
}

@Override
public void update(ExecutionContext arg0) throws ItemStreamException {
    delegate.update(arg0);
}