public  void PassData(){
    Intent GoToReport=new Intent(getApplicationContext(), createProject.class);
    MemberBudgetPassData= MemberBudget.getText().toString();
    BudgetHoursPassData = budgetHours.getText().toString();
    Toasty.info(popupActivity.this, StaffArray.toString(),Toasty.LENGTH_LONG).show();


    GoToReport.putString("Array",new Gson.toJson(StaffArray));

    startActivity(GoToReport);
    Animatoo.animateCard(popupActivity.this);
}