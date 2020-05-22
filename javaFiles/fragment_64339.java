String charset = "UTF-8";
        String s = "unit_type=" + URLEncoder.encode(MainActivity.distance_units, charset);
        s += "&long=" + URLEncoder.encode(String.valueOf(MainActivity.mLongitude), charset);
        s += "&lat=" + URLEncoder.encode(String.valueOf(MainActivity.mLatitude), charset);
        s += "&user_id=" + URLEncoder.encode(String.valueOf(MyndQuest.userId), charset);

        conn.setFixedLengthStreamingMode(s.getBytes().length);
        PrintWriter out = new PrintWriter(conn.getOutputStream());
        out.print(s);
        out.close();