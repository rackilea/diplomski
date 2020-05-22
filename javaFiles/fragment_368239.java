String EMPTY;
   int stopHERE;
   if (lastReading.isItTimeYet(Calendar.getInstance()))
    {
        lastReadingReturn = lastReading.SensorReadingChanges(z_value, chkOrient, inclination, rotation);
        if (lastReadingReturn.isEmpty())
        {
            EMPTY = "TRUE";
            // DO NOTHING
            System.out.println("Doing nothing");
        }
        else
        {
            stopHERE = 0;
            System.out.println("stopHERE set to zero");
        }
    }