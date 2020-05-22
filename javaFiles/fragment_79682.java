teacherAdapter.setOnItemClickListener(new TeacherAdapter.OnItemClickListener() {
    @Override
    public void onItemClick(DocumentSnapshot documentSnapshot, int position) {

        String path = documentSnapshot.getReference().getPath();
        Intent intent = new Intent(TeacherActivity.this, SecondActivity.class);
        intent.putExtra(EXTRA_PATH, path);
        startActivity(intent);

    }
});