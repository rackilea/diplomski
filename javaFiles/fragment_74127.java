spinner1.setOnItemSelectedListener(
    new OnItemSelectedListener() {
        public void onItemSelected(AdapterView <? > parent, View view, int position, long id) {
            spinner1position = position;

            spinnerPos();

            showToast("spinnerdotw: position= " + position + "id=" + id);
        }

        \\ ...

    });