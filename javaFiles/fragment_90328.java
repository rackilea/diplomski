try{
        CSVReader reader = new CSVReader(new FileReader("b2b_control_number_bkup.csv"));
         String [] nextLine;

         int counter = 0;

         // First File Variables
         String SENDER_NAME = null;
         String RECEIVER_NAME = null;
         String DOC_PROTOCOL_NAME = null;
         String DIRECTION = null;
         String NAME = null;
         String IS_DEFAULT = null;
         /*
         String INTERCHANGE = null;
         String GROUP_NUM  = null;
         String TRANSACTION_NUM = null;
         */
         int INTERCHANGE = 0;
         int GROUP_NUM  = 0;
         int TRANSACTION_NUM = 0;

         //Second File variables
         String SENDER_NAMEb = null;
         String RECEIVER_NAMEb = null;
         String DOC_PROTOCOL_NAMEb = null;
         String DIRECTIONb = null;
         String NAMEb = null;
         String IS_DEFAULTb = null;
         /*
         String INTERCHANGEb = null;
         String GROUP_NUMb  = null;
         String TRANSACTION_NUMb = null;
         */
         int INTERCHANGEb = 0;
         int GROUP_NUMb  = 0;
         int TRANSACTION_NUMb = 0;

         while ((nextLine = reader.readNext()) != null) {
             //System.out.println(nextLine[4] +" "+ nextLine[5] +" "+ nextLine[6]);
             SENDER_NAME = nextLine[0];
             RECEIVER_NAME = nextLine[1];
             DOC_PROTOCOL_NAME = nextLine[2];
             DIRECTION = nextLine[3];

             INTERCHANGE = Integer.parseInt(nextLine[4]);
             GROUP_NUM  = Integer.parseInt(nextLine[5]);
             TRANSACTION_NUM = Integer.parseInt(nextLine[6]);

             NAME = nextLine[15];
             IS_DEFAULT = nextLine[16];


             // nextLine[] is an array of values from the line

             CSVReader readerb = new CSVReader(new FileReader("b2b_control_number_current.csv"));
             String [] nextLineb;

             while ((nextLineb = readerb.readNext()) != null) {
                 SENDER_NAMEb = nextLineb[0];
                 RECEIVER_NAMEb = nextLineb[1];
                 DOC_PROTOCOL_NAMEb = nextLineb[2];
                 DIRECTIONb = nextLineb[3];

                 INTERCHANGEb = Integer.parseInt(nextLineb[4]);
                 GROUP_NUMb  = Integer.parseInt(nextLineb[5]);
                 TRANSACTION_NUMb = Integer.parseInt(nextLineb[6]);

                 NAMEb = nextLineb[15];
                 IS_DEFAULTb = nextLineb[16];


                 //System.out.println(nextLineb[4] +" "+ nextLineb[5] +" "+ nextLineb[6]);
                 //System.out.println("RECEIVER_NAMEa: " + RECEIVER_NAME +" "+ RECEIVER_NAMEb);
                 if((SENDER_NAME.equals(SENDER_NAMEb))
                         && (RECEIVER_NAME.equals(RECEIVER_NAMEb)) 
                         && (DOC_PROTOCOL_NAME.equals(DOC_PROTOCOL_NAMEb)) 
                         && (DIRECTION.equals(DIRECTIONb)) 
                         && (NAME.equals(NAMEb)) 
                         && (IS_DEFAULT.equals(IS_DEFAULTb))){
                     if((INTERCHANGE<=(INTERCHANGEb)) && (GROUP_NUM<=(GROUP_NUMb)) && (TRANSACTION_NUM<=(TRANSACTION_NUMb))){
                         pw.println("Everything Okay");
                     }else{
                         pw.println("Error Send Email");
                         sendEmail ="1";
                       }


                     //System.out.println("RECEIVER_NAME: " + RECEIVER_NAME +" "+ RECEIVER_NAMEb);
                     pw.println("INTERCHANGE: " + INTERCHANGE +" "+ INTERCHANGEb +
                             "   GROUP_NUM: " + GROUP_NUM +" "+ GROUP_NUMb+ 
                             "   TRANSACTION_NUM: " + TRANSACTION_NUM +" "+ TRANSACTION_NUMb);
                 }
             }
            /*
               counter ++;

             if(counter == 2){
             break;
             }
             */
             readerb.close();
         }
         reader.close();
         }catch(Exception e){
             e.printStackTrace();
         }