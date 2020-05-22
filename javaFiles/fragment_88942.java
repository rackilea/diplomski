public void onClick(View v) {
        switch(v.getId()){
            case R.id.calculate:
                TableRowcalculatenumberinflated = (TableRow)findViewById(R.id.tablerow);
                View view = getLayoutInflater().inflate(R.layout.calculatenumbertable,calculatenumberinflated,false);
                calculatenumberinflated.addView(view);
                break;
            case R.id.unevensplit:
                break;
        }
    }