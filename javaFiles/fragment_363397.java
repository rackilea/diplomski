String Query = "select * from recommendation.sports WHERE feed LIKE '%" + s1 + "%' " +
                "UNION " +
                "select * from recommendation.software  WHERE feed LIKE '%" +s1+ "%' " +
                "UNION " +
                "select * from recommendation.website   WHERE feed LIKE '%" +s1+" %' " +
                "UNION " +
                "select * from recommendation.others    WHERE feed LIKE '%"+s1+"%' " +
                "UNION " +
                "select * from recommendation.business  WHERE feed LIKE '%" +s1+ "%'" ;