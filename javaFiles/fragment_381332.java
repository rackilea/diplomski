String SQL_INSERT = "INSERT INTO emp (Username, Name, Age, Password) VALUES (?,?,?,?);
try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase", "root", "Luxan@22");
             PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT)) {

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, pwd);

            int row = preparedStatement.executeUpdate();

            // rows affected
            System.out.println(row); //1

        } catch (SQLException e) {
            System.err.format("SQL State: %s \n %s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }