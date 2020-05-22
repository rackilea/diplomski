while ((line = br.readLine()) != null) {
        infoAdults = line.split(csvSplitBy);
        adultsID = new String[500];
        for(int i=0;i<infoAdults.length;i++){
            if(infoAdults[i].isEmpty()){
                infoAdults[i]="9999";
            }
            if(i>16){
                adultsID[0]=infoAdults[16];
            }
            else{
                adultsID[0]="9999";
            }
        }