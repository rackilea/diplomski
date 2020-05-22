private void PlaySequenc(){
    for(int i = 0 ; i < CurrentSequenceLeingth ; i++)
    {
        panBoard[Sequence[i]/2][Sequence[i]%2].pressPane();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
    }
}