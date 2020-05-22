for (DataSnapshot ds: dataSnapshot.getChildren()) {
    String name = ds.child("name").getValue(String.class);
    String grade = ds.child("grade").getValue(Integer.class);

    if(name.equals("Tom")) {
        gradeOne.setText(Integer.toString(grade));
        studentNameTV.setText(name);
    }

    if(name.equals("Andrew")) {
        gradeTwo.setText(Integer.toString(grade));
        studentNameTV2.setText(name);
    }

    if(name.equals("Melissa")) {
        gradeThree.setText(Integer.toString(grade));
        studentNameTV3.setText(name);
    }
}