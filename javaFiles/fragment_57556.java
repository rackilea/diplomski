AsyncTask s=new InnerClass().execute();
        try {
            Post a=(Post)s.get();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }