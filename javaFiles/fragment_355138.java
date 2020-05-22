class MouseClickListener implements MouseListener
{
    public void mouseClicked (MouseEvent event)
    {
        Object source = event.getSource();
        for (int x = 0; x < casesArray.length; x++) {
            for (int y = 0; y < casesArray[x].length; y++) {
                if (casesArray[x][y] == source) {
                    casesArray[x][y].setIcon(null);
                    break;
                }
            }
        }
    }
}