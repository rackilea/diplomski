public static Comparator<QualityData> COMPARATOR=new Comparator<QualityData>(){
            public int compare(QualityData data1, QualityData data2){
                if((data1.getSequence_nr()-data2.getSequence_nr() == 0)){
                    if(data1.getSubSequence_nr()-data2.getSubSequence_nr() == 0){
                        if(data1.getFlag()){
                           return 1;    
                        }else{
                            return -1;
                        }
                    }else{
                        return data1.getSubSequence_nr()-data2.getSubSequence_nr();
                    }
                }else {
                    return data1.getSequence_nr()-data2.getSequence_nr();
                }
            }
        };
        }