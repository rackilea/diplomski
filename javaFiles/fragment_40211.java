@Override
public void onViewCreated(View view, Bundle savedInstanceState){
    tv = (TextView) getActivity().findViewById(R.id.clockText);
    // Displaying the user details on the screen
    try {
       tv.setText(getFileText());
    } catch (IOException e) {
        e.printStackTrace();
    }
}


public String getFileText() throws IOException {
    File path = getActivity().getExternalFilesDir(null); //sd card
    File file = new File(path, "alarmString.txt"); //saves in Android/
    BufferedReader br = new BufferedReader(new FileReader(file));
try {
    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
    }

} finally {
    br.close();
}
return sb.toString()
}