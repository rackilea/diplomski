else if(inf.contains("Main booker") ||  inf.contains("Haupt-Bucher") || inf.contains("Hoofdboeker")){  
            if(!MainBooker(doc, i)[2].equals("-")){              
                informationBasic.add(MainBooker(doc, i)[1] +" "+MainBooker(doc, i)[2]+ " "+ MainBooker(doc, i)[3]);
            }
            else if(MainBooker(doc, i)[2].equals("-")){
                informationBasic.add(MainBooker(doc, i)[1] + " "+ MainBooker(doc, i)[3]);
            }
            mainbooker.addAll(Arrays.asList(MainBooker(doc, i)));
        }