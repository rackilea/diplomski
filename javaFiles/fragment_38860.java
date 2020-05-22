List<Task<DocumentSnapshot>> tasks = new ArrayList<>();
for (String uid: uidList) {
    Task<DocumentSnapshot> documentSnapshotTask = users.whereEqualTo(Consts.UID, uid).get();
    tasks.add(documentSnapshotTas);
}
Tasks.whenAllSuccess(tasks).addOnSuccessListener(new OnSuccessListener<List<Object>>() {
    @Override
    public void onSuccess(List<Object> list) {
        //Do what you need to do with your users list
        for (Object object : list) {
            FsUser fsUser = ((DocumentSnapshot) object).toObject(TeacherPojo.class);
            Log.d("TAG", fsUser.getName());
        }
    }
});