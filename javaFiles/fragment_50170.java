public static void main(String[] args) {


        Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler() {

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                Date date = new Date(); // faire le new Date() ici, en dehors du block, garanti d'avoir une heure au plus juste, mais les traces pourraient être au final dans le désordre dans le fichier
                synchronized (System.err) {
                   System.err.print(simpleDateFormat.format(date) );
                           System.err.print(" Exception in thread \""+t.getName()+"\" "); 
                   e.printStackTrace(System.err);
                }
             }
        });

        Integer i = null;
        String str = i.toString();

    }