PreparedStatement pst = session.prepare(
        select().all()
                .from("foo")
                .where(eq("k", bindMarker()))
                .limit(bindMarker("l")));     // here

session.execute(pst.bind()
        .setInt("k", 1)
        .setInt("l", 10));