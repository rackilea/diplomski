private void stage1() {
    List<Promise<Void>> promiseList = new ArrayList<Promise<Void>>();
    Promise<Void> promise1 = activityClient.activity1();
    Promise<Void> promise2 = activityClient.activity2();
    Promise<Void> promise3 = activityClient.activity3();

    promiseList.add(promise1);
    promiseList.add(promise2);
    promiseList.add(promise3);

    stage2(promiseList);
}

@Asynchronous
private void stage2(@Wait List<Promise<Void>> promiseList) {
    activityClient.activity4();
}