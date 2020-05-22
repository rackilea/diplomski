@RequestMapping(params="/updateDate")
public @ResponseBody String updateDate(HttpServletRequest request
        , @RequestParam Integer productId
        , @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date dateReceived) {
    // Code here...
}