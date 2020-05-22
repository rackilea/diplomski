for(int i = 0; i<rainfall.size(); i++){
   if(maxRain == rainFall[i])
         maxIndex = i;
   if(minRain == rainFall[i])
         minIndex = i;

}

smallMonth = months[minIndex];
bigMonth = months[maxIndex];