while (scan.hasNext()) 
    {
     String scanStr = scan.next();
        if(scanStr.toLowerCase().equals("car") )
        {
            carsdata[count++] = new Car(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next() ,scan.nextInt(), scan.nextDouble(), scan.next(), scan.next(), scan.next(), scan.next());
        }

        if(scanStr.toLowerCase().equals("motorcycle"))
        {
            motorcyclesdata[count++] = new Motorcycle(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next() ,scan.nextInt(), scan.nextDouble(), scan.next(), scan.next(), scan.next(), scan.next());
        }

        if(scanStr.toLowerCase().equals("van"))
        {
            vansdata[count++] = new Van(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next() ,scan.nextInt(), scan.nextDouble(), scan.next(), scan.nextInt(), scan.next());
        }

        if(scanStr.toLowerCase().equals("pickup"))
        {
            pickupsdata[count++] = new Pickup(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next() ,scan.nextInt(), scan.nextDouble(), scan.next(), scan.nextInt(), scan.nextInt(), scan.next());
        }
    }