@RequestMapping(value = "startup", method = RequestMethod.GET)
public @ResponseBody ProcessResponse startUp(@RequestBody RequestTemplate requestTemplate, HttpServletRequest request) {

        System.out.println(request.getRemoteAddr());
        // some other code
}