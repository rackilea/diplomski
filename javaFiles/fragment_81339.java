public void updateArguments(Bundle args) { 
     ArrayList<Set> x = new ArrayList<>(); 
     x = (ArrayList<Set>) args.getSerializable("sets"); 
     for(Set p: x) { 
        array.add(p); 
     } 
     mAddExerciseAdapter.notifyDataSetChanged(); 
   }