@Override
public void actionPerformed(ActionEvent e) {
    Staff staff = new Staff();
    staff.setName(JOptionPane.showInputDialog("Enter First Name"));
    staff.setSurname(JOptionPane.showInputDialog("Enter Second Name"));
    staff.setDate(JOptionPane.showInputDialog("Enter Date"));
    staff.setPosition(JOptionPane.showInputDialog("Enter Position"));
    staff.setSalary(JOptionPane.showInputDialog("Enter Salary"));
    try {
        Factory.getInstance().getStaffDAO().addStaff(staff);
        ((MyTableModel)model).add(staff);
    } catch (SQLException e1) {
        e1.printStackTrace();  
    }
}