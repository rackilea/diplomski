public int CountRecord(ImageItemBin bin)
{
    showImagelist.add(showBin);
    int size=showImagelist.size();
    tvcounter.setText(Integer.toString(size));
    btnShow.setText(Integer.toString(size));
    return 0;
}