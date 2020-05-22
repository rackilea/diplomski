String text = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";        
try {
    response.getWriter().write(text);
    response.getWriter().close();
    return;
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    return;
}