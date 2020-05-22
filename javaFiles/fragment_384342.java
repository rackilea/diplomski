final View popUpView = getLayoutInflater().inflate(R.layout.exp, null);
    listPopupWindow = new PopupWindow(popUpView, LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT, true);
    expandableListView= (ExpandableListView) popUpView.findViewById(R.id.expandableListView);
    btnticker.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            expandableListDetail = ExpandableListDataPump.getData();
            expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

            expandableListAdapter = new CustomExpandableListAdapter(MainActivity.this, expandableListTitle, expandableListDetail);
            expandableListView.setAdapter(expandableListAdapter);

            listPopupWindow.showAsDropDown(v);
        }
    });