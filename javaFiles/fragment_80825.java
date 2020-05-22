for (int j=1; j<10; j++)
    {
        setImages("drawable/img" +j);
        //  SetPopup(drag);
    }

void setImages(final String draw)
{
    int id12 = getResources().getIdentifier(draw, "id", "your_package_name");
    drag1.setImageResource(id12);