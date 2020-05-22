public void onBackPressed() {
    super.onBackPressed();
    threadIsStopped = true;
    Intent intent = new Intent(Logistic_ReportProblem.this, FPAgentHome.class);
    startActivity(intent);
    finish();
}