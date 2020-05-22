public class FirebasePagerAdapter extends FragmentStatePagerAdapter {

    private List<Survey> surveyList = new ArrayList<>();
    private List<Fragment> surveyFragments = new ArrayList<>();

    private ValueEventListener valueEventListener;
    private DatabaseReference surveyReference;

    public FirebasePagerAdapter(FragmentManager fm) {
        super(fm);
        surveyReference = FirebaseDatabase.getInstance().getReference().child("root/survey");
        surveyReference.addEventListener(valueEventListener);
        valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                surveyList.clear();
                surveyFragments.clear(); // if you implement .equals() in Survey
                // you do a for loop that only updates the changed/added/removed items, instead of all of them..

                for(DataSnapshot surveySnapshot: snapshot.getChildren()){
                    String surveyNumber = surveySnapshot.getKey();
                    Survey survey = surveySnapshot.getValue(Survey.class);
                    surveyList.add(survey);
                    surveyFragments.add(SurveyFragment.newInstance(surveyNumber, survey));
                }
                notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error){
                //...
            }
        };
    }

    @Override
    public Fragment getItem(int position) {
        return surveyFragments.get(position);
    }

    @Override
    public int getCount() {
        return surveyFragments.size();
    }

    public void cleanup() {
        if (valueEventListener != null) {
            surveyReference.removeEventListener(valueEventListener);
        }
    }
}