@RequestMapping("/index")
public String Createuser(@RequestParam(value="uname") String name,@RequestParam(value="pass") String pass, Model model){
    User user = new User();
    user.setUname(name);
    user.setPass(pass);
    create.adduser(user);
    return "result";

}