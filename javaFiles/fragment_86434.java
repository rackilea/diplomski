String sql2="INSERT INTO itemspoinfo (PODate, PONo, ItemName,Qty) VALUES(?,?,?,?)";
        pst2=conn.prepareStatement(sql2);
        // to check drugs details are added or not.
        int noofdrugs = 0;
        if (drug1!=null && drug1.length()>0)
            && (qty1!=null && qty1.length()>0)) {
            pst2.setTimestamp(1, timestamp);
            pst2.setString(2, porderno);
            pst2.setString(3, drug1);
            pst2.setInt(4, Integer.parseInt(qty1));
            pst2.addBatch();

            noofdrugs++;
        }

        if (drug2!=null && drug2.length()>0)
            && (qty2!=null && qty2.length()>0))
        {
            pst2.setTimestamp(1, timestamp);
            pst2.setString(2, porderno);
            pst2.setString(3, drug2);
            pst2.setInt(4, Integer.parseInt(qty2));
            pst2.addBatch();

            noofdrugs++;
        }

        if (drug3!=null && drug3.length()>0)
            && (qty3!=null && qty3.length()>0))
        {
            pst2.setTimestamp(1, timestamp);
            pst2.setString(2, porderno);
            pst2.setString(3, drug3);
            pst2.setInt(4, Integer.parseInt(qty3));
            pst2.addBatch();

            noofdrugs++;
        }

        if (drug4!=null && drug4.length()>0)
            && (qty4!=null && qty4.length()>0))
        {
            pst2.setTimestamp(1, timestamp);
            pst2.setString(2, porderno);
            pst2.setString(3, drug4);
            pst2.setInt(4, Integer.parseInt(qty4));
            pst2.addBatch();

            noofdrugs++;
        }

        if (drug5!=null && drug5.length()>0)
            && (qty5!=null && qty5.length()>0))
        {
            pst2.setTimestamp(1, timestamp);
            pst2.setString(2, porderno);
            pst2.setString(3, drug5);
            pst2.setInt(4, Integer.parseInt(qty5));
            pst2.addBatch();

            noofdrugs++;
        }

        if (noofdrugs>0) {
            pstmt.executeBatch();
        }