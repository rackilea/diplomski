class UserData {
  private final String username;
  private final String password;

  UserData(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}

class Registration {
  private final List<UserData> userData = new ArrayList<>();

  public void regUser() {
    String regName = JOptionPane.showInputDialog(null, "Enter User Name:");
    String regPass = JOptionPane.showInputDialog(null, "Enter User Password:");
    userData.add(new UserData(regName, regPass));
  }

  public void login() {
    String name = JOptionPane.showInputDialog(null, "Enter User Name:");
    String password = JOptionPane.showInputDialog(null, "Enter User Password:");

    boolean isValidUser = userData.stream()
        .anyMatch(user -> user.getUsername().equals(name) && user.getPassword().equals(password));

    if (isValidUser) {
      JOptionPane.showMessageDialog(null, "Welcome to Rent A Car\n All cars data here....");
    } else {
      JOptionPane.showMessageDialog(null, "Wrong login info please try again");
    }
  }
}