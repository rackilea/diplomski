int port;

    if ( args.length != 1 ) {
        System.out.println("listening to port 9999");
        port = 9999;
    } else {
        port = Integer.parseInt ( args[ 0 ] );

    }