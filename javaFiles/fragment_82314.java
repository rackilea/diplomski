text=data.getText().toString();
    PrintWriter writer=null;

    try {
        FileOutputStream os = openFileOutput(filename, Context.MODE_PRIVATE);
        writer=new PrintWriter(os);
    } catch (Exception e) {
        // log exception
        }
    writer.print(text);
    writer.flush();
    writer.close();
    msg.setText("Data Saved Successfully");