public class NymiAsync extends AsyncTask<Integer,Integer,Integer> {
    @Override
    protected Integer doInBackground(Integer... integers) {
        try{
            startValidatingNymi();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
}