//Update - need UserDetail model attribute
@RequestMapping(value = "/userDetail", method = RequestMethod.PUT)
public String updateUserDetail(@Valid UserDetail userDetail,
        Errors errors, Map<String, Object> map,
        final RedirectAttributes redirectAttributes) {
    if (errors.getErrorCount() > 0) {
        //log.info("User attempt update user: " + userDetail.toString());
        for (FieldError error : errors.getFieldErrors()) {
            log.info(error.getField() + ": " + error.getDefaultMessage());
        }
        //redirect to same page to show error return infor (NotEmpty etc...)
        redirectAttributes.addFlashAttribute("userDetail", userDetail);
        redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "userDetail", errors);
        return "redirect:/user/userDetail/error";
    } else {
        try {
            //update user detail
            userDetailService.updateUserDetail(userDetail);

        } catch (Exception e) {
            String tmp = e.getLocalizedMessage();
            String tmp2 = e.toString();
            //log.error("Failed to update UserDetail: " + userDetail.toString());
        }
        return "redirect:/user/userDetails";
    }
}


//Display form with validation error after update fail (PUT -> Redirect -> GET)
@RequestMapping(value = "/userDetail/error", method = RequestMethod.GET)
public String inputUserDetail_error() {
    //Here will auto retrieve previous redirectAttributes data and put into the JSP page.
    return "/user/inputUserDetail";
}