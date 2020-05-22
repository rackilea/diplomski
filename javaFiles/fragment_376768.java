while (rs.next()) {
            int itm = rs.getString("itemcode");
            int price = rs.getString("price");
            int remaining = rs.getString("remaining");

            System.out.println(itm + "\t" + price +
                               "\t" + remaining );
        }