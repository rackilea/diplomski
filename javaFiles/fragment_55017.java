while (rs.next())
            {
                searchBean.setFirstName(rs.getString("firstName"));
                searchBean.setLastName(rs.getString("lastName"));
                searchBean.setUserId(rs.getString("userId"));
                searchBean.setDisplayname(rs.getString("displayname"));

           Mylist.add(searchBean);

            }