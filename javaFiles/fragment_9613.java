//if there is no search value load the whole list
if (TextUtils.isEmpty(text)) {
    filteredList.addAll(chordsList);
} else {
    //iterate through the original list and add to the filteredList
    for (Chord chord : chordsList) {
        if(chord.getName().toLowerCase().contains(text.toLowerCase()))  {
            filteredList.add(chord);
        }
    }
}

recyclerView.notifyDataSetChanged();