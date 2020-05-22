float result = 0;
float[] resultList = new float[1];
for (int k = 0; k < latitudeList.size() - 1; k++)
{
    Location.distanceBetween(latitudeList.get(k), longitudeList.get(k),           latitudeList.get(k+1), longitudeList.get(k + 1), resultList);                        
    result = result + resultList[0];

}