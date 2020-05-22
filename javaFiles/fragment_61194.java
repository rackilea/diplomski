public class Experiment implements Iterable
{
    private DNAChain[] chains; // Chains found in the experiment
    private int counter; // next  chain  index

    public  Experiment () {}
    public  Experiment (int  n) { chains  = new DNAChain[n]; }

    public DNAChain[] getChains() { return chains; }
    public void setChains(DNAChain[] chains) { this.chains = chains; }

    public class ExpIteratorImpl implements ExpIterator
    {
        @Override
        public void setLevel(int n) { }

        @Override
        public boolean hasNext() { return counter < chains.length; }

        @Override
        public DNAChain next() { return chains[counter++]; }
    }

    @Override
    public Iterator iterator() { return new ExpIteratorImpl(); }
}