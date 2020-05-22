List<Course> courseList = new ArrayList<Course>(Arrays.asList(courses));
// initialize the adapter with courseList instead of courses 
final ArrayAdapter<Course> adapter = new ArrayAdapter<Course>(this, android.R.layout.simple_list_item_1, courseList);

// this code inside the Button's onClick
int points = Integer.parseInt(editText.getText().toString());
for (Course c : courses) {
    if (c.getPoints() <= points) {
        adapter.add(c);
    }
}