public class ReadFileToList{ 

    private final ArrayList<String> list = new ArrayList<String>();
    private final Context context;

    public ReadFileToList(Context context){
        this.context = context;

        myFunction();
    }

    private void myFunction() throws IOException { 

        final Resources resources =  context.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.texttext);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder strBuild = new StringBuilder();

        try {
            String line;

            while ((line = reader.readLine()) != null) {
                list.add(line);
            }




        } finally {
            reader.close();
        }
        return list; 
    }

    public ArrayList<String> getList(){
        return list;
    }
}