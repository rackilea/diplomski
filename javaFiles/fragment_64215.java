if(lc.isAdmin())
{
    System.out.println("lc is admin");
    model.addAttribute("bp",new BlogPost());
    return "newPost";
} else
{
    System.out.println("lc is not admin");
    return "login";
}