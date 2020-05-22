@ResponseBody
@RequestMapping(method = RequestMethod.POST)
public T addEntity(@RequestBody State state, HttpServletResponse httpResponse) {
    T response = null;
    try {
        response = getService().add(state);
    } catch (Exception e) {
        httpResponse.setStatus(400);
        e.printStackTrace();


    }
    return response;

}