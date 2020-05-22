for(int i =0;i<allPPLlat.size();i++){
           double Dist= Distance((double)allPPLlat.get(i),(double)allPPLlong.get(i),latitude,longitude);
            Dist=Dist/1000;
            if(Dist<20){
                Donors.add(new DonorPerson(""+allPPLNames.get(i)+"", ""+allPPLEmails.get(i)+"" ,""+allPPLNumbers.get(i)+"" ,""+allPPLImages.get(i)+""));
            }
        }