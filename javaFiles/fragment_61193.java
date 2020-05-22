@Override
public Iterator<DNAChain> iterator()
{
    return new Iterator<DNAChain>()
    {
        @Override
        public boolean hasNext() { return false; }

        @Override
        public DNAChain next() { return null; }

    };
}