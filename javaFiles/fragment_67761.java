String term = termName.split(":")[1].trim();
switch (which) {
    case 0:
        Context c = MainActivity.this;
        Intent i = new Intent(c, CourseListActivity.class);
        i.putExtra("termName", term);
        c.startActivity(i);
        break;
    case 1:
        db.delete("termTable", "name = '" + term + "'", null);
        termListAdapter.notifyDataSetChanged();
}