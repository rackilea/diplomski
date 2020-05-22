AlphabeticListView listView = 
        (AlphabeticListView) findViewById(R.id.alphabeticListView1);

listView.setAdapter(adapter);
listView.setAlphabet(alphabet);
listView.setSections(sections);
listView.updateList();