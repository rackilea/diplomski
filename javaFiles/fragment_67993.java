autocompletetextview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            for (int j = 0; j < listSchool.size(); j++) {
                if (listSchool.get(j).getSchool_name().equals(adapter.getItem(i).toString())) {

                    school_name = listSchool.get(j).getSchool_name();
                    school_id = listSchool.get(j).getSchool_id();

                    break;
                }
            }

        }
    });