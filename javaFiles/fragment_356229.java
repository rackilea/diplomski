do{

            try
            {
                Thread.sleep(1000);
                sek++;
                System.out.println(sek);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }

            db = new BdsPostgres( );
                db.select(Result.SET_1, "SELECT * FROM connection_overview WHERE leitung="+leitung+" AND  status='pull' ");  
                db.naechsterDatensatz(Result.SET_1);

                anzahlPulls = db.leseZeilen(Result.SET_1);
            db.schliessen();

        }while (anzahlPulls != 0 && sek != 60);