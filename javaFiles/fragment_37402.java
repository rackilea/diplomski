int total = 0;
        int count = 1;

        while(scanner.hasNext()) {
            if(scanner.hasNextLine()){
                String data=scanner.nextLine();
                String numberData=data.substring(data.indexOf(",") +1);
                numberData = numberData.substring(0, numberData.indexOf("%"));              
                total=total+Integer.parseInt(numberData);
            }
        }
        System.out.println(total);
        scanner.close();
    }