boolean quit = false;
    while (!quit)
    {
        System.out.print("Enter download size: ");
        megaBytes = sc.nextInt();

        System.out.print("Enter download speed: ");
        megaByteSpeed = sc.nextInt();

    if (megaBytes < 1000)
        {
            totalSeconds = megaBytes / megaByteSpeed;
            hours = totalSeconds / 3600;
            secondsRemainder = totalSeconds % 3600;
            minutes = secondsRemainder / seconds;
            seconds = minutes % 60;

        }
        String message = "\n" 
                       +  "This download will take approximately " + hours + "hours" + minutes + "minutes and " + seconds + "seconds";
        System.out.println(message);

        System.out.println("Do you want to continue 1= yes 0 = no");
        int ans  = 0;
        ans = sc.nextInt();
        if(ans ==0){
            quit = true;
        }
    }