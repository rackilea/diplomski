@Override
public void onClick(View v) 
{
        System.out.println("check"+getListView().getCheckItemIds().length);

        for (int i = 0; i < getListView().getCheckItemIds().length; i++)
        {
            System.out.println(getListView().getAdapter().getItem((int)getListView().getCheckItemIds()[i]).toString());                 
        }   

}