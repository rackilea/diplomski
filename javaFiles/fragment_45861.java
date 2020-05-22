private void addValue(){
    activityCount++;
    onlineStatus = true;
}

private void removeValue(){
    activityCount--;
    if(activityCount <= 0)
        onlineStatus = false;
}