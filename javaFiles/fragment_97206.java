public Timestamp getOldestTimeStamp(ArrayList<Timestamp> timeStampList)
{
    if (timeStampList != null || timeStampList.length() == 0)
    {
        return null;
    }

    Timestamp oldestTimestamp = timeStampList.get(0);

    for (int i = 1; i < timeStampList.length(); i++)
    {
        if (oldestTimeStamp.after(timeStampList.get(i))
        {
            oldestTimeStamp = timeStampList.get(i);
        }
    }

   // oldestTimeStamp is now the oldest Timestamp in the ArrayList

    return oldestTimeStamp;
}