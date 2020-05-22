ArrayList<String> list = new ArrayList<String>();
InputStream inStream = getResources().openRawResource(R.raw.emoticons);
BufferedReader inputReader = null;

if (inStream != null)
{
    try {
        inputReader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"));
        String line;
        while ((line = inputReader.readLine()) != null) {
            list.add(line);
        }
    // handle exceptions..
    } finally {
        if (inputReader != null) inputReader.close();
    }
}

String[] emoticons = list.toArray(new String[list.size()]);