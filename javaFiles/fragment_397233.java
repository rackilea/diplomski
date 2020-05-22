JSONArray parameter=main.getJSONArray("parameter");
float[] avgTemp=new float[24];

//for 24 hours of the day
for(int i=0;i<24;i++){
     int occurence=0;
     float totalTemp=0;
     for(int j=0;j<parameter.size();j++){
          int time=convertTime(parameter.get(j).getString("time"));
          if(time==i){
               totalTemp+=Float.parseFloat(parameter.get(j).getString("temp"));
               occurence++;
              }
         avgTemp[i]=(totalTemp/occurence);
         }
    }