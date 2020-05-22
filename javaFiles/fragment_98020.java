public class SunRiseSetAlgo
    {
        static double calcSunrise(int dayOfYear, double localOffset, double latitude, double longitude)
        {
            return calc(dayOfYear, localOffset, latitude, longitude, true);
        }
        static double calcSunset(int dayOfYear, double localOffset, double latitude, double longitude)
        {
            return calc(dayOfYear, localOffset, latitude, longitude, false);
        }

        // http://williams.best.vwh.net/sunrise_sunset_algorithm.htm
        static double calc(int dayOfYear, double localOffset, double latitude, double longitude, boolean rise)
        {
            //1. first calculate the day of the year

    //        int N1 = floor(275 * month / 9.0);
    //        int N2 = floor((month + 9) / 12.0);
    //        int N3 = (1 + floor((year - 4 * floor(year / 4.0) + 2) / 3.0));
    //        int N = N1 - (N2 * N3) + day - 30;
            int N = dayOfYear;

            //2. convert the longitude to hour value and calculate an approximate time

            double lngHour = longitude / 15;
            double t = rise?
                N + (( 6 - lngHour) / 24) :
                N + ((18 - lngHour) / 24);

            //3. calculate the Sun's mean anomaly

            double M = (0.9856 * t) - 3.289;

            //4. calculate the Sun's true longitude

            double L = M + (1.916 * sin(M)) + (0.020 * sin(2 * M)) + 282.634;
            L = mod(L, 360);

            //5a. calculate the Sun's right ascension
            double RA = atan(0.91764 * tan(L));
            RA = mod(RA, 360);

            //5b. right ascension value needs to be in the same quadrant as L
            double Lquadrant  = (floor( L/90)) * 90;
            double RAquadrant = (floor(RA/90)) * 90;
            RA = RA + (Lquadrant - RAquadrant);

            //5c. right ascension value needs to be converted into hours
            RA = RA / 15;

            //6. calculate the Sun's declination
            double sinDec = 0.39782 * sin(L);
            double cosDec = cos(asin(sinDec));

            //7a. calculate the Sun's local hour angle
            double zenith = 90 + 50.0/60;
            double cosH = (cos(zenith) - (sinDec * sin(latitude))) / (cosDec * cos(latitude));

            if (cosH >  1)
              throw new Error("the sun never rises on this location (on the specified date");
            if (cosH < -1)
              throw new Error("the sun never sets on this location (on the specified date");

            //7b. finish calculating H and convert into hours
            double H = rise?
                360 - acos(cosH) :
                acos(cosH);
            H = H / 15;

            //8. calculate local mean time of rising/setting
            double T = H + RA - (0.06571 * t) - 6.622;

            //9. adjust back to UTC
            double UT = T - lngHour;

            //10. convert UT value to local time zone of latitude/longitude
            double localT = UT + localOffset;
            localT = mod(localT, 24);
            return localT;
        }

        static int floor(double d){ return (int)Math.floor(d); }

        static double sin(double degree)
        {
            return Math.sin(degree*Math.PI/180);
        }
        static double cos(double degree)
        {
            return Math.cos(degree*Math.PI/180);
        }
        static double tan(double degree)
        {
            return Math.tan(degree*Math.PI/180);
        }
        static double atan(double x)
        {
            return Math.atan(x) *180/Math.PI;
        }
        static double asin(double x)
        {
            return Math.asin(x) *180/Math.PI;
        }
        static double acos(double x)
        {
            return Math.acos(x) *180/Math.PI;
        }

        static double mod(double x, double lim)
        {
            return x - lim * floor(x/lim);
        }

    }