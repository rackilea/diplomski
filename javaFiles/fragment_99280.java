@Override
public Iterator<Virus> iterator() {
    final Iterator<Virus> delegate = super.iterator();
    return new Iterator<Virus>() {
        @Override
        public boolean hasNext() {
            return delegate.hasNext();
        }
        @Override
        public void remove() {
            // put your custom remove logic here
            //  ...
            delegate.remove();
        }
        @Override
        public Virus next() {
            return delegate.next();
        }
    };
}