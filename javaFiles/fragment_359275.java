public class AlarmReceiver extends BroadcastReceiver {

    private static final String DEBUG_TAG = "AlarmReceiver";
    public AppDatabase mydb;
    Plan plan;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Alarm worked.", Toast.LENGTH_LONG).show();
        mydb = AppDatabase.getInstance(context);
        final long planid = intent.getExtras().getLong("planid");
        final long userid = intent.getExtras().getLong("uid");
        final String requirements = intent.getExtras().getString("requirements");
        Log.wtf("PlanId: ",planid+"");
        Log.wtf("UserId: ",userid+"");
        Log.wtf("Requirements",requirements);
        plan = mydb.getPlanDao(context).getPlanById((int) planid);
        final User user = mydb.getUserDao(context).getUserById((int) userid);
        plan.setCurrentWeight(FormulaUtils.reCalculateWeight(plan.getCurrentWeight(), Double.parseDouble(requirements)));
        plan.setBmr(Double.parseDouble(FormulaUtils.calculateBmr(user.getSex(), plan.getCurrentWeight(), user.getHeight(), user.getBirthDay())));
        plan.setNbOfDays(plan.getNbOfDays() - 1);
        mydb.getPlanDao(context).update(plan);

        // Calculate all data before sending to feature2 activity
        String requirement = FormulaUtils.CalulcateDailyRequirements(plan.getWorkoutPerWeek(), plan.getBmr());
        String day = plan.getNbOfDays() + "";
        float progress = 0F;

        // Start feature2 activity with updated data
        Intent updateFeature2Intent = new Intent(context, feature2.class);
        updateFeature2Intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP); // Add this flag
        newIntent.putExtra("requirement", requirement);
        newIntent.putExtra("day", day);
        newIntent.putExtra("progress", progress);
        context.startActivity(newIntent);
    }
}