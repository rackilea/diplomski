while(true)
{
    final int qRow = input.nextInt();
    final int qCol = input.nextInt();
    final int sRow = input.nextInt();
    final int sCol = input.nextInt();

    SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
            move(qRow,qCol,sRow,sCol);
        }
    });

}