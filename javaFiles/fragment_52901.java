String notesInStorage = pref.getString(Integer.toString(counter), newNote);

  if(notesInStorage != null)
        {
            Map<String,?> keys = pref.getAll();

            for(Map.Entry<String,?> entry : keys.entrySet()){

                notesofrules.add(entry.getValue().toString());
                adapter = new CustomListAdapter(getActivity(), notesofrules, cross);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        }