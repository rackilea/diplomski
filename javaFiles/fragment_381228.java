String substring;
while (!SENTINEL.equals(website))    
    {
        substring = website.substring(website.length()-3);  
        if(substring.equals(commercialNames))
        { 
            count++;
        }
        System.out.print( "Enter the next site > ");
        website = scan.next();

    }