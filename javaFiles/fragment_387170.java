private void initComponents() {
    // your code....

    try {
        ResultSet rs = db.getAllAppUsers();
        if (rs != null) {
            while (rs.next()) {
                String name = rs.getString("NAME");
                int id = rs.getInt("ID"); 
                model.addElement(new User(name, id));
            }
            list = new JList(model);
        }
    } catch (Exception e) {
        list = new JList();
    }

    // your code...
}

@Override
public void actionPerformed(ActionEvent e
) {
    if (e.getSource() == btnOk) {
        User selectedItem = (User) list.getSelectedValue();
        userDetail.setUserName(selectedItem.getName());
        int id = selectedItem.getId();
        this.dispose();
    }
}

public class User {
   private String name;
   private Integer id;

   public User(String name, Integer id) {
       this.name = name;
       this.id = id;
   }

   public String getName() {
       return name;
   }

   public Integer getId() {
      return id;
   }

   @Override
   public String toString() {
      return name;
   }
}