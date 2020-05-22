float s1=0;
        float d1=0;
        float s2=0;
        float d2=0;
        float s3=0;
        float d3=0;

        for (ScanResult result: results) {  
            String name = result.SSID;
            if ("rubelwifii".equals(name)) {
                s1=result.level;
                d1 =30*(1-(2*(s1+100)/100));
                System.out.println(result.SSID);
                System.out.println(s1);
                System.out.println(d1);
            }
            else if  ("ABDULHAKEEM".equals(name))  {
                s2=result.level;
                s2 =30*(1-(2*(s2+100)/100));
                System.out.println(result.SSID);
                System.out.println(s2);
                System.out.println(d2);
            }
            else if ("shamwifi".equals(name))  {
                s3=result.level;
                d3 =30*(1-(2*(s3+100)/100));
                System.out.println(result.SSID);
                System.out.println(s3);
                System.out.println(d3);
            }
            else {
                System.out.println("name ["+name+"] was not one of the known spots");
            }
        }

        float distanc = d1+d1+d3;
        System.out.println(distanc);