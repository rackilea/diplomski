public class AllStudents extends AppCompatActivity {
    .....

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ....

        StudentListView.setOnItemClickListener(...)


        // add TextChangedListener to search box.
        // It listens for user's entered text & filter students' list by name
        EditText searchEditText = (EditText) findViewById(R.id.search);

        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after) {
            }

            // when text is entered in search box, filter list by search text
            @Override
            public void onTextChanged(CharSequence cs, int start, int before, int count) {
                filterStudents(cs);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }


    // check student's name whether contain text entered in search box
    private void filterStudents (CharSequence cs) {
        List<Student> filteredList = new ArrayList<>();

        if (TextUtils.isEmpty(cs)) {
            // no text is entered for search, do nothing
            return;
        }

        // build new student list which filtered by search text. 
        for (Student student : studentList) {
            if (student.StudentName.contains(cs)) {
                filteredList.add(student);
            }
        }

        // show filtered list in listview
        ListAdapter adapter = new ListAdapter(filteredList, this);

        StudentListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }