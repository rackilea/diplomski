private static Integer getUniqueIdNumber() {
    Random ran = new Random();
    int randomButtonId = ran.nextInt(20) + 1;

    if(buttonIdList.contains(randomButtonId)) {
        return getUniqueIdNumber();
    } else {
        buttonIdList.add(randomButtonId);
    }

    return randomButtonId;
}