public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    email = dataSnapshot.child("email").getValue().toString();
                    full_name = dataSnapshot.child("full_name").getValue().toString();
                    roll_number = dataSnapshot.child("roll_number").getValue().toString();
                    admission_id = dataSnapshot.child("admission_id").getValue().toString();
                    phone_no = dataSnapshot.child("phone_number").getValue().toString();
                    branch = dataSnapshot.child("branch").getValue().toString();
                    year = dataSnapshot.child("year").getValue().toString();
                    semester = dataSnapshot.child("semester").getValue().toString();
                    section = dataSnapshot.child("section").getValue().toString();
                    course = dataSnapshot.child("course").getValue().toString();
                    batch = dataSnapshot.child("batch").getValue().toString();
                    dob = dataSnapshot.child("dob").getValue().toString();
                    address = dataSnapshot.child("address").getValue().toString();