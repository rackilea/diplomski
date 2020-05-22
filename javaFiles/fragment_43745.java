TimerTask checkApi = new TimerTask(){
    @Override
    public void run(){
        try {
            JSONObject changes = new JSONObject(/* External class that gets data from URL */);
            if (changes.getBoolean("success")){

                /* This is where the data is parsed */

                /* Example skeleton code: */

                 JSONObject parsed_data = changes.getJSONObject("some_data");

                 if (changes.has("possibly missing detail")){
                     parseData(changes, changes.getString("possibly missing detail"));
                 } else {
                     // todo: Ask user for detail
                     AlertDialog.Builder dialog_builder = new AlertDialog.Builder(MainActivity.this);
                     View mView = getLayoutInflater().inflate(R.layout.dialog_spinner, null);
                     dialog_builder.setMessage(R.string.need_detail_message);
                     dialog_builder.setTitle(R.string.need_detail_title);
                     final Spinner spinner = (Spinner) mView.findViewById(R.id.spinner);
                     List<String> detail_list = /* details from external class */;
                     detail_list.add(0, getString(R.string.need_detail_select));
                     ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, detail_list);
                     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                     spinner.setAdapter(adapter);

                     dialog_builder.setPositiveButton(R.string.CONTINUE_GENERAL, new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             // Do nothing yet
                         }
                     });

                     dialog_builder.setView(mView);

                     final AlertDialog dialog = dialog_builder.create();
                     dialog.setCancelable(false);
                     dialog.setCanceledOnTouchOutside(false);
                     dialog.show();
                     dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                         @Override
                         public void onClick(View v) {
                             String selection = spinner.getSelectedItem().toString();
                             if (!selection.equals(getString(R.string.need_detail_select))){
                                 // todo: send to function
                                 parseData(changes, selection);
                                 dialog.dismiss();
                             } else {
                                 Toast.makeText(Tracking.this, R.string.need_detail_toast, Toast.LENGTH_SHORT).show();
                             }
                         }
                     });
                 }
             } else {
                 e.printStackTrace();
             }
         } catch (JSONException e){
             e.printStackTrace();
         }
     }
 };

 private void parseData(JSONObject changes, String detail){
     /* Do werk */
 }