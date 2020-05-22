@RequestMapping("/{envId}/entityList1")
public void getEntityList1(
    final HttpServletResponse response,
    final @PathVariable Integer envId) throws IOException {
        response.sendRedirect("/enitytList1/" + 
        Integer.toString(envId));
}