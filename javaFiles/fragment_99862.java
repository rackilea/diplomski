while (rs.next())
           {
              AbastosOpLog abasop = new AbastosOpLog(); 
              abasop.setAbas_cod(rs.getString("abascod"));
              abasop.setAbas_desc(rs.getString("abasdesc"));
              abastosop.add(abasop);
           }