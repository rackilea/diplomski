String[] myStr = args ;
        System.out.print("My String is ");
        for (int i=0; i<args.length; i++) {
            myStr[i] = args[i];
            System.out.print(myStr[i]);
        }
        System.out.print("\n");
        return 0;