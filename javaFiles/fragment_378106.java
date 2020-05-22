long holdTime = eventTime - pressTime;
if (holdTime > 7000 && holdTime < 20000) {
    Toast t = Toast.makeText(this, "5 sec to 20 sec", 5);
    t.show();
} else if (holdTime > 5000 && holdTime <= 7000) {
    Toast t = Toast.makeText(this, "5 sec", 5);
    t.show();
}