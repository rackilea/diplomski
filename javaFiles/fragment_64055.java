public void createOrder(Model model, @Valid @ModelAttribute Order order, BindingResult errors,HttpSession session){


    if (errors.hasErrors()) {
        // error handling code goes here.
        System.out.println("inside controlelr");
      }