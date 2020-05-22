@Controller
public class RegisterController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value="/registerForm.htm",method=RequestMethod.GET)
    public ModelAndView registerPage(ModelMap map){
        User user=new User();
         map.addAttribute(user);
        return new ModelAndView("registerForm","command",user); 
    }

    @RequestMapping(value="/registerProcess.htm",method=RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("user") User user,Model model){
        model.addAttribute("userName", user.getUserName());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("emailId",user.getEmailId());
        System.out.println("user is "+user);
        System.out.println("userdao is"+userDao);
        userDao.saveUser(user);
        return new ModelAndView("registerProcess","user",user);
    }

    //this is the new method with proper mapping
    @RequestMapping(value="/userList.htm", method=RequestMethod.GET)
    public ModelAndView registerPage(ModelMap map) {
        //this method should retrieve the data for all users
        List<User> userList = userDao.getAllUsers();
        map.addAttribute("userList", userList);
        return new ModelAndView("userList", map);
    }
}