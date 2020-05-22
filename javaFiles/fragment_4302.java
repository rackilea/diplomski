private void readFromParcel(Parcel in)
{
    id = in.readInt();
    startDate = new Date(in.readLong());

    long date = in.readLong();
    if (date != 0L)
    {
        endDate = new Date(date);
    }
} 

public void writeToParcel(Parcel dest, int flags)
{ 
    dest.writeInt(id); 
    dest.writeLong(startDate.getTime());

    if (endDate != null)
    {
        dest.writeLong(endDate.getTime());
    }
    else
    {
        dest.writeLong(0L);
    }
}