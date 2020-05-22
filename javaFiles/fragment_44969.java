private static Random ran = new Random();
private static Integer getUniqueIdNumber() {
    int randomButtonId = ran.nextInt(20) + 1;
    if(buttonIdList.contains(randomButtonId)) {
        return getUniqueIdNumber();
    } else {
        buttonIdList.add(randomButtonId);
        return randomButtonId;
    }
}