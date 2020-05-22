Icelandic i1 = new Icelandic();  // i1 = firstObject --> Location XXXX
        Icelandic i2 = new Icelandic();  // i2 = secondObject --> Location YYYY
        Icelandic i3 = new Icelandic();  // i3 = thirdObject  ---> Location ZZZZ

        i3 = i1;
        // HERE i3 = i1; i3 --> XXXX; i1 --> XXXX; i2 --> YYYY  
        (ZZZZ No reference)

         i1 = i2;
        // Here i1 --> YYYY; i2 --> YYYY; i3 --> XXXX

        i2 = null;
        // Here i2 --> null; i1-->YYYY; i3 --> XXXX

        i3 = i1;
        // Here i1-->YYYY; i2 --> NULL; i3--> YYYY 
       (No reference for XXXX and ZZZZ)