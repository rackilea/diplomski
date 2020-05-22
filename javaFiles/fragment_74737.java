@RequestMapping(value = "/attachement", method = RequestMethod.GET)
@ResponseBody
public void getAttachment(OutputStream out) {

    InputStream in = ; // Set this to the InputStream from HTTP as your provided example
    byte[] buffer = new byte[1024]; // You will need a small buffer mem though
    int len;
    while ((len = in.read(buffer)) != -1) {
        out.write(buffer, 0, len);
    }
    in.close();
    out.flush();
}