@RequestMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        for (int i = 0; i < 10; i++) {
            writer.println(i);
            writer.flush();
            Thread.sleep(50000);
        }
    }