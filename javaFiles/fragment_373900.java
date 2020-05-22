list.setSelectionModel(new DefaultListSelectionModel() 
{
    @Override
    public void setSelectionInterval(int index0, int index1) 
    {
        if(list.isSelectedIndex(index0)) 
        {
            list.removeSelectionInterval(index0, index1);
        }
        else 
        {
            list.addSelectionInterval(index0, index1);
        }
    }
});