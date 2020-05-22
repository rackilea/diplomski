@RequestMapping("/top/pages/{pageno}")
    @ResponseBody 
     public List<Post> getAllPosts(@PathVariable("pageno") int pageno, HttpServletRequest req, HttpServletResponse res) throws ServletException {

List<Post> postobj = postDao.getAllPostsByRank(new PageRequest(pageno,10));
return postobj;
}