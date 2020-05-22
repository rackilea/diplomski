public class fetchData extends AsyncTask<Void,Void,Void> {
    String data ="";
    String factTitle = "";
    String factDesc = "";
    String factImg ="";
    String singleParsed ="";
    String DoubleParsed ="";
    String tripleParsed ="";
    Activity mContext;
    TextView mfactTitle,mfactDesc;
    ImageView mfactImg;
    ProgressBar mProgressbar;

   public fetchData(Activity context,TextView mfactTitle,TextView 
   mfactDesc,ImageView mfactImg,ProgressBar mProgressbar){
   this.context=context;
   this.mfactTitle=mfactTitle; 
   this.mfactDesc=mfactDesc;
   this.mfactImg=mfactImg;
   this.mProgressbar=mProgressbar;
   }
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://xxxxxx.com/api");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONArray JA = new JSONArray(data);
            for(int i =0 ;i <JA.length(); i++){
                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed =  ""+JO.get("fact");
                DoubleParsed =  ""+JO.get("factdesc");
                tripleParsed =  ""+JO.get("img");
                factTitle = factTitle + singleParsed;
                factDesc  = factDesc + DoubleParsed;
                factImg  = factImg + tripleParsed;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mfactImg.setVisibility(View.VISIBLE);
        mfactTitle.setText(this.factTitle);
        mfactDesc.setText(this.factDesc);
     Picasso.get().load(factImg).placeholder(R.drawable.defaultthumb).into(mfactImg);
       mProgressBar.setVisibility(View.INVISIBLE);
    }
}