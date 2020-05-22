public Double[] berekenY()
    {
        yWaardes = new Double[ecgWaardes.length]; 
        for (int i = 0; i < ecgWaardes.length; i++)
        {

            yWaardes [i] = (double)(((ecgWaardes[i] - sMax) * (SCHERMHOOGTE-1)) / (sMin - sMax));

        }
        return yWaardes;
    }