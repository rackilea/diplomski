List<User> list = new ArrayList<User>();

      try {

           users_sel.setInt(1, 1);
           users_curs = users_sel.executeQuery();

           // RETRIEVE ROWS FROM USERS
           while (users_curs.next()) {

                int lv_u_id = users_curs.getInt("u_id");
                String lv_u_name = users_curs.getString("u_name");

                uinfo_sel.setInt(1, lv_u_id);
                uinfo_curs = uinfo_sel.executeQuery();

                // RETRIEVE DATA FROM UINFO RELATIVE TO USER
                String lv_ui_info = uinfo_curs.getString("ui_info");
                String lv_ui_extra = uinfo_curs.getString("ui_extra");

                User user = new User(lv_u_id, lv_u_name, lv_ui_info, lv_ui_extra);

                // STORE DATA
                list.add(user);
        }

      } catch(SQLException log) {
           // EVERYTHING BROKE
      }

      // MAKING SURE IT WORKED
      list.get(0).print();