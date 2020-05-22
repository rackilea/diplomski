listViewSchool.setOnItemClickListener(new AdapterView.OnItemClickListener()
{
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
    {
        // Get the School Name from School Adapter

        String schoolName = ((School) adapterView.getItemAtPosition(position)).[GetSchoolName()]; 

        // Create intent to pass data and call another Activity.

        Intent intent = new Intent(activity, [YourStudentActivity].class);

        // Add data to intent

        intent.putExtra("schoolName", schoolName);

        // Call the Student Activity

        startActivity(intent);
    }
});