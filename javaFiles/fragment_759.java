public double GetDistanceFromLatLong(double lat1, double lon1, double lat2, double lon2, string unit)
    {
        double ReturnValue = 0;
        double theta = 0;
        double dist = 0;
        theta = lon1 - lon2;
        dist = Math.Sin(DegreesToRadians(lat1)) * Math.Sin(DegreesToRadians(lat2)) + Math.Cos(DegreesToRadians(lat1)) *
               Math.Cos(DegreesToRadians(lat2)) * Math.Cos(DegreesToRadians(theta));
        dist = Math.Acos(dist);
        dist = RadiansToDegrees(dist);
        ReturnValue = dist * 60 * 1.1515;

        switch (unit.ToUpper())
        {
            case "K":
                ReturnValue = ReturnValue * 1.609344;
                break;
            case "M":
                ReturnValue = ReturnValue * 0.8684;
                break;
        }
        return ReturnValue;
    }