<!-- language: lang-java -->
 protected void checkGoal(){

        int progress = calculateProgress();

        if(goalPref.getInt("Goal",0)!=0){

            if(progress >= goalPref.getInt("Goal", 0)) {

                String newString = goalPref.getInt("Goal", 0) + "€, " + MainActivity.currentDate();
                goalsCompleted.add(newString);
                updateGoalCompletedList();

                //Here I clean the layout and display all the TextViews
                layout.removeAllViews();
                for(int i=goalsCompleted.size()-1; i>0; i--){
                    addNewTextView(i);
                }

                question.setText(R.string.setgoal);

                updateGoalPref(0);

                if (list.size() != 0) {
                    list = new ArrayList<>();
                }
                updateProgress();
            }
        }
    }

//The function used to display the TextViews
 protected void addNewTextView(int id){

        TextView textView = new TextView(this);
        textView.setBackgroundResource(R.drawable.check1);
        textView.setId(id);
        textView.setPadding(25,260,0,0);
        textView.setTextSize(12);
        textView.setText(goalsCompleted.get(id));
        layout.addView(textView);
    }

//The function used to update and save the array
  public void updateGoalCompletedList(){

        Gson gson3 = new Gson();
        jsonItems3 = gson3.toJson(goalsCompleted);
        SharedPreferences.Editor listEd = goalsCompletedPref.edit();
        listEd.putString("GoalsCompleted", jsonItems3).apply();

    }

//The function used to resume the array, you can call it on onResume() or onCreate()
  public void resumeGoalsCompleted(){

        Gson gson3 = new Gson();
        String savedList = goalsCompletedPref.getString("GoalsCompleted", "");
        goalsCompleted = gson3.fromJson(savedList, new TypeToken<ArrayList<String>>() {
        }.getType());

        if(goalsCompleted==null)
            goalsCompleted = new ArrayList<>();

        //From the most recent to the least recent
        for(int i=goalsCompleted.size()-1; i>0; i--){
            addNewTextView(i);
        }
    }