//create an array of ids
    int[] editextIDs = {R.id.tv1
            ,R.id.tv2
            ,R.id.tv3
            ,R.id.tv4
            ,R.id.tv5
            ,R.id.tv6
            ,R.id.tv7
            ,R.id.tv8
            ,R.id.tv9
            ,R.id.tv10
            ,R.id.tv11
            ,R.id.tv12
            ,R.id.tv13
            ,R.id.tv14
            ,R.id.tv15
            ,R.id.tv16
            ,R.id.tv17
            ,R.id.tv18
            ,R.id.tv19
            ,R.id.tv20
            ,R.id.tv21
            ,R.id.tv22
            ,R.id.tv23
            ,R.id.tv24
            ,R.id.tv25
    };
    //create an arraylist of 25 editTexts
    ArrayList<EditText> editTexts = new ArrayList<>();
    //fill the array
    for(int i = 0; i < 25 ;i++)
    {
        editTexts.add(i,(EditText) findViewById(editextIDs[i]));
    }
    //set the texts
    for(int i = 25; i <25 ;i++)
    {
        editTexts.get(i).setText(stall);
    }