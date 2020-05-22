@RequestMapping (value = "edit", method = RequestMethod.POST, params="action=ADD")
{
    public String saveUser(@ModelAttribute UserDto userDto) {
        try {
            User user = new User();
            if(userDto.getId() != null) {   
                throw new UserExists();
            }
            user.setName(userDto.getName());
            user.setEmail(userDto.getEmail());
            System.err.println("Request Recieved");
            userDao.save(user);
            return "redirect:/success";
        } catch (Exception e) {
            System.err.println("Error Saving User");
            e.printStackTrace();
            return "redirect:/failure";
        }
    }

@RequestMapping("/success")
public String successPage(){
    return "success";
}

@RequestMapping("/failure")
public String failurePage(){
    return "failure";
}