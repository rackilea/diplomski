public class feature2 extends AppCompatActivity {

    ...

    // Add this method
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        // Get data from intent
        String requirement = intent.getStringExtra("requirement");
        String day = intent.getStringExtra("day");
        float progress = intent.getFloatExtra("progress", 0F);

        // Update UI
        TextView requirements = findViewById(R.id.requirements);
        TextView Days = findViewById(R.id.days);
        DonutProgress dailyProgress = findViewById(R.id.donut_progress);

        requirements.setText(requirement);
        Days.setText(day);
        dailyProgress.setProgress(progress);
    }
}