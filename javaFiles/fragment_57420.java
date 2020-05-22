while (in.hasNext()){        //Sentinel condition
            count++;                    //Keeps count of students
            name = in.next();
            if(name.equals("ENDDATA")){
               break;
            }
            spanish=in.nextInt();
            math=in.nextInt();
            french=in.nextInt();
            english=in.nextInt();
            sum = spanish + math + french + english;
            avg = sum/4;                                    //Claculates Average
            System.out.printf("%s - %.0f\n",name,avg);

                if (avg > highAvg){                         //Checks for the highest Average
                    highAvg = avg;
                    highName = name;
                }
                if (spanish > highSpan){
                    highSpan = spanish;
                }
                if (math > highMath){
                    highMath = math;                        //Checks for the highest mark for each subject
                }
                if (french > highFren){
                    highFren = french;
                }
                if (english > highEng){
                    highEng = english;
                }


 }