@Override
public Iterator<Thing> iterator() {
    return new Iterator<Thing>() {

        private Thing current = Thing.this;

        public boolean hasNext() {
            return current.hasNext();
        }

        public Thing next() {
            current = current.next;
            return current;
        }

    };
}