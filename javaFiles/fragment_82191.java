// below prepared statement has already been prepared, we're now just re-using
PreparedStatement ps = session.prepare("SELECT * FROM users WHERE uname=?");

1) session.execute(ps.bind('david');
2) session.execute("SELECT * FROM users WHERE uname=david");
3) session.exectute(QueryBuilder.select()
                                .all()
                                .from("users")
                                .where(QueryBuilder.eq('uname', 'david'))