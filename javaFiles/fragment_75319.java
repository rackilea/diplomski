public void CollectThePages(int Num1,int Num2){
        int startpage = Num1;
        int endpage = Num2;
        int Number = startpage;
        int Day = 1;
        int DailyPages = 9;

        while(Number <= endpage){
            HashMap<String,String> data = new HashMap<>();
            System.out.print("Day Number " + Day);
            data.put("day", "Day " + Day);
            ++Day;
            System.out.print("From " + Number);
            data.put("from", "From " + Number);
            int prevNumber = Number;
            Number += DailyPages;
            Number = Number > endpage ? endpage : Number;
            int NumberofPages = Number - prevNumber + 1;
            System.out.print(" To " + Number);
            data.put("to", "To " + Number);
            System.out.print(" | The Pages are " + NumberofPages);
            data.put("NOP", NumberofPages + " Pages");
            ++Number;
            valueList.add(data);
        }

        ValueList = (ListView) findViewById(R.id.valueList);
        //Out of The Loop
        valueListAdapter = new ValueListAdapter(getApplicationContext(),valueList);
        ValueList.setAdapter(valueListAdapter);
    }