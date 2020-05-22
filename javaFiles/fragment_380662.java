@RequestMapping(value = "/function/{functionId}/image.gif", produces = "image/gif")
public void getImage(@PathVariable(value = "functionId") String functionId, HttpServletResponse response) throws IOException {
    Function function = functionService.getFunction(Integer.valueOf(functionId));

    ImageOutputStream servOut = ImageIO.createImageOutputStream(response.getOutputStream());

    // Uses default values if you pass in nulls.
    function.getImage(servOut, null, null);

    servOut.close();
}