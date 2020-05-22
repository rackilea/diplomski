private class Client extends AsyncTask<String,Void,String>{

    Socket s;
    @Override
    protected String doInBackground(String... arg0) {
        // TODO Auto-generated method stub

        try {
            s = new Socket(arg0[0],Integer.parseInt(arg0[1]));
            s.close();
            return "Connection Established"
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    @Override
    protected void onPostExecute(String result){
        if (result != null) {
            Toast.makeText(ctx,result , Toast.LENGTH_SHORT).show();          
        } else {
            Toast.makeText(ctx,"Error" , Toast.LENGTH_SHORT).show();                  
        }
    }
}