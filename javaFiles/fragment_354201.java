String[] strLine2 = {"seared","chunky","out of stock"} ;      

        int start = 0;
        while (m.find(start)) {
            System.out.printf("Word found: %s at index %d to %d.%n", m.group(), m.start(), m.end());
            for(String lineWords: strLine2){
            if(strLine1.contains(lineWords)){
               System.out.println(list + " is " + lineWords);
                        }
            }
            start = m.end();

        }