if ( args.length < 3 ){ 
        System.out.println("There I print my content, size is less than 3");
        //print your content 
        } 
        else if( args.length == 3 ) { //You didnt point out what you want to do if size is equal to 3
        System.out.println("Size is equal to 3");
        }
        else if( args.length > 3 ) {
         throw new ArrayIndexOutOfBoundsException("Out of Bounds Exc. Size is 4 or more"); 
        }