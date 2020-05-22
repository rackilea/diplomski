class myCounter {
    private int _ix = 1;

    public int ixAdd()
    {
        return _ix++ + giveMeZero();
    }

    public int giveMeZero()
    {
        System.out.println(_ix);
        return 0;
    }
}