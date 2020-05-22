Statement statement = connection.createStatement();
statement.execute("insert into student values (3,'kamal')");
connection.commit();

Statement statement1 = connection1.createStatement();
statement1.execute("delete from student where student_id = 3");
connection1.commit();