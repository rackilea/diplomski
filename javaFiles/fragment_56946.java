ResultSet rs=st.executeQuery("select * from thread_question where question_dateTime='"+question_post_date+"'");
    if(rs.next())
    {
        String question_id=rs.getString("question_id");
        response.sendRedirect("http://localhost:8072/forum_website/showThread.jsp?id="+question_id);
        return;
    }