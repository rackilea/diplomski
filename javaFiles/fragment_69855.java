public void onTextChanged(CharSequence s, int start, int before, int count) {
    String searchString = myFilter.getText().toString();
    RigsTemp.clear();
    if (s.length() > 0) {
        for (int i = 0; i < Rigs.size(); i++) {
            if (searchString.equalsIgnoreCase(Rigs.get(i).getName())) {
                    Rig rigtemp = new Rig();
                    rigtemp.setName(Rigs.get(i).getName());
                    rigtemp.setImageUrl(Rigs.get(i).getImageUrl());
                    rigtemp.setRigId(Rigs.get(i).getRigId());
                    RigsTemp.add(rigtemp);
                }
            }
    } else {
        // Only if you want to show all results when user has not entered anything in EditText
        // Else remove this line to show empty ListView at start
        RigsTemp.addAll(Rigs);
    }
    adapter.notifyDataSetChanged();
}