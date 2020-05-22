public class MyFragment extends Fragment
    {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState)
        {
            view = inflater.inflate(R.layout.myfragment, container, false);


            writeFile("text.txt", view.getContext());
            String[] test = readFile("text.txt", view.getContext());
            if(test==null)
            {
              // error to read file or file dont exists
            }else
            {
              //read file
            }    
            return view;
        }

 public static String   newline = System.getProperty("line.separator");

// write file
private void writeFile(String filename, Context context)
{

    File file = new File(context.getFilesDir(), filename);

    // write data if file dont exists
    if (!file.exists())
    {
        String string = "data" + newline + "data" + newline + "data"
                + newline + "data" + newline + "data" + newline + "data"
                + newline;

        FileOutputStream outputStream;

        try
        {
            outputStream = context.openFileOutput(filename,
                    Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

// read file and convert data to String array
private String[] readFile(String filename, Context context)
{
    try
    {
        File file = new File(context.getFilesDir(), filename);
        if (!file.exists())
        {
            return null;
        }
        FileInputStream fis = new FileInputStream(file);
        byte[] dataByte = new byte[(int) file.length()];
        fis.read(dataByte);
        fis.close();
        String data = new String(dataByte);
        // slit string with newline <\n>

        return data.split(newline);
    } catch (Exception e)
    {
        e.printStackTrace();
    }
    return null;


}
}