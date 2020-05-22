// Using two different layouts 
@Override
public int getViewTypeCount()
{
    return 2;
}

// Get the type of item  
@Override
public int getItemViewType(int position)
{
    if (arrayList.get(position).isUserType())
    {
        return ITEM_USER;
    }
    else
    {
        return ITEM_PHOTO;
    }
}

@Override
public View getView(int position, View convertView, ViewGroup parent)
{
    if (getItemViewType(position) == ITEM_USER)
    {
        // Inflate first layout
    }
    else
    {
        // Inflate second layout
    }
}