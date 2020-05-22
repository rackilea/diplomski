@RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendMoney(Data data) {
        //here will be your code for send money and whatever you have to do..
        ...send(data.getAddress(), data.getAmount()); 
        return "redirect:/"; //here will the location where you want to redirect
    }