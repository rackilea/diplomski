stationSpinner.setOnItemSelectedListener(new StationSpinnerListener());

...

private class StationSpinnerListener implements OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parentView, 
                               View selectedItemView, 
                               int position, 
                               long id) {
        String newStreamUrl;
        switch (position) {

            case 0:
                // 128kb 89.7 stream
                // Default case, always executed on activity creation.
                newStreamUrl = "defaultStreamUrl";
                changeStream(newStreamUrl);
                break;

            case 1:
                // 320kb stream
                newStreamUrl = "URL1";
                changeStream(newStreamUrl);
                break;

            case 2:
                // 128kb Stream 2
                newStreamUrl = "URL2";
                changeStream(newStreamUrl);
                break;

            case 3:
                // 320kb Steam 2
                newStreamUrl = "URL3";
                changeStream(newStreamUrl);
            }   
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parentView) {
    }
}