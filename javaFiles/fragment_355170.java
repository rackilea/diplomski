UPDATE student_info SET Lastname=? ID=? Age=? WHERE Firstname=?
//--------------------------1----^--2-^--3--^----------4------^

UpdateStatement.setString(1,FirstName);//<<-----this should be Lastname
UpdateStatement.setString(2,LastName);//<<-----this should be ID
UpdateStatement.setInt(3,ID);//<<-----this should be Age
UpdateStatement.setInt(4,Age);//<<-----this should be Firstname