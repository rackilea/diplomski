@Controller
@RequestMapping("/errors")
public class ErrorController {

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public void errorRedirect(HttpServletRequest request, HttpServletResponse response) {

        // Get original request URI
        String uri = (String)request.getAttribute(WebUtils.ERROR_REQUEST_URI_ATTRIBUTE);

        // Try to determine file extension
        String filename = WebUtils.extractFullFilenameFromUrlPath(uri);
        String extension = StringUtils.getFilenameExtension(filename);
        extension = StringUtils.hasText(extension) ? "." + extension : "";

        // Forward request to appropriate handler with original request's file extension (i.e. /errors/404.json)
        String forwardUri = "/errors/404" + extension); 
        request.getRequestDispatcher(forwardUri).forward(request, response);
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<ErrorResponse> error404() {

        ErrorResponse errorBody = new ErrorResponse(404, "Resource Not Found!");

        return new ResponseEntity<ErrorResponse>(errorBody, HttpStatus.NOT_FOUND);
    }
}