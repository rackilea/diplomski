final class ImmutableA extends A 
{
    public ImmutableA(int value) {
        synchronized (this) {
            super.setValue(value);
        }
    }

    public void setValue(int value) {
        throw new UnsupportedOperationException();
    }

    public synchronized int getValue() {
        return super.getValue();
    }
}