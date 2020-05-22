int[] options= new int[] {
    R.array.Électron_P,
    R.array.Monstre_P,
    R.array.Neutron_P
};

int resId = options[POSITION1 - 1];
ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(Main2Activity.this,
            R.layout.simple_list_item_single_choice_2,
            getResources().getStringArray(resId));
listView.setAdapter(mAdapter);