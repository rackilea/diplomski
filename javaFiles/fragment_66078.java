protected void onPostExecute(String result){
    try {
    ...
    //....create the spinner....
            event_spinner.setAdapter(eAdapter);

            event_spinner.setOnItemSelectedListener(..... // create the listener
            //removed code for easy reading......

                String selected_event = event_spinner.getSelectedItem().toString();
                //Here I want to store the value for use in another class.
                callback.aMethodWhereYouUseSelectedEvent(selected_event);

                }
    }