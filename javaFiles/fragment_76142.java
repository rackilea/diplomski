final JSONObject myObject = new JSONObject();

checkBox.setOnClickListener(new View.OnClickListener() {

    String idSelected = dataRecord.getID();

    public void onClick(View v) {


        if (((CheckBox) v).isChecked()) {

        try {
              myObject.put(dataRecord.getID(), true);
        } catch (JSONException e) {
              e.printStackTrace();
        }


            ParseUser parseUser= ParseUser.getCurrentUser();
            parseUser.put("checklistData", myObject);
            parseUser.saveInBackground();

            Toast.makeText(getContext(), idSelected,
                    Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(getContext(), "CheckBox is unchecked",
                    Toast.LENGTH_SHORT).show();

        }
    }
});