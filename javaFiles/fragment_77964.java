private void startNextActivity() {
        Intent nextActivity = new Intent(this, NextActivity.class);
        nextActivity.putExtra("robot.id", mRobot.getUniqueId());
        goingToNextActivity = true;
        startActivity(nextActivity);
    }

    @Override
    protected void onStop() {
        super.onStop();

        // don't disconnect if headed to "NextActivity"
        if (!goingToNextActivity) {
            RobotProvider.getDefaultProvider().disconnect(mRobot);
            mRobot = null;
        }
    }