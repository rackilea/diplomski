public Map<Integer,Integer> getAvailableTime(Date date, Integer guru_fid) {
                return jdbctemp.query("Select a.hour, s.duration from appointment as a inner join services as s on a.service_fid=s.id where date=? and guru_fid=? ",new Object[] { date, guru_fid }, (ResultSet rs) -> {
                HashMap<Integer,Integer> results = new HashMap<>();
                while (rs.next()) {
                    results.put(rs.getInt("a.hour"), rs.getInt("s.duration"));
                }
                return results;
            });

        }