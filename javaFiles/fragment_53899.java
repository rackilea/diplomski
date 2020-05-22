while (scan2.hasNext()) //here you are checking for Sacnner Object 2
        {
            if(scan2.next().toLowerCase().equals("motorcycle"))
            {
//here you are using Scanner Object 1 only make sure you intended to implement it to read it from scanner Object 1 only
                motorcyclesdata[count++] = new Motorcycle(scan.next(), scan.nextInt(), scan.nextInt(), scan.next(), scan.next() ,scan.nextInt(), scan.nextDouble(), scan.next(), scan.next(), scan.next(), scan.next()); 
            }
        }