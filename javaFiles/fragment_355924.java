btnAddStudent.setOnClickListener(
        new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                .... (Write those 3 lines here)

                boolean isInserted = myDb.insertDataStudent(
                        Integer.parseInt(sid.getText().toString()),
                        fn.getText().toString(),
                        ln.getText().toString(),
                        radioGenderButton.getText().toString(),
                        cs.getText().toString(),
                        Integer.parseInt(ag.getText().toString()),
                        ad.getText().toString()

                );

                if(isInserted == true)
                    Toast.makeText(Addrecord.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(Addrecord.this,"Data not Inserted",Toast.LENGTH_LONG).show();
            }
        }
);