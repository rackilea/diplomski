CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        try {
            String msg ="";
            if (isChecked) {
                // The toggle is enabled

                //msg = "Hello " + String.valueOf(!isChecked);
                msg = buttonView.getTag().toString()


            } else {
                // The toggle is disabled
                //msg = "Hello " + String.valueOf(!isChecked);
                msg = buttonView.getTag().toString()
            }
            msg += "\n";
            outputStream.write(msg.getBytes());

        } catch (IOException ex) {

        }
        catch (NullPointerException ex) {

        }
    }
};

toggle1.setTag("1");
toggle2.setTag("2");
toggle3.setTag("3");

toggle1.setOnCheckedChangeListener(listener);
toggle2.setOnCheckedChangeListener(listener);
toggle3.setOnCheckedChangeListener(listener);