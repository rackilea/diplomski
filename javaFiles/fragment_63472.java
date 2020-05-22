@RequestMapping(value="/assets", method = RequestMethod.POST)  
public String checkInOut(@ModelAttribute("inOutTransaction") @Validated InOutTransaction inOutTransaction, 
BindingResult result, Model model, Locale locale, HttpServletRequest request) {
 try {
     if(result.hasErrors()){
         return "checkinout";
     }
     InOutTransactionDO inOutTransactionDO = new InOutTransactionDO();
/*CODE*/
     if(employeeInfoDO == null){
         model.addAttribute("serverError", "User "+ inOutTransaction.getUserId()+" does not exist !"); 
         return "checkinout";
     }
/*CODE*/
     if(deviceMasterDO == null){
         model.addAttribute("serverError", "Device Id "+ inOutTransaction.getAssetTagNumber()+" not found !"); 
         return "checkinout";           
     }
     inOutTransactionService.saveTransaction(inOutTransactionDO);
     request.getSession().setAttribute("successMessage", "Transaction inserted Successfully !"); 
     return "checkinout";
      } catch (Exception e) {   
        model.addAttribute("serverError", e.toString()); 
        return "checkinout";  
      }
}