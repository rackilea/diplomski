@RequestMapping(value="/myProfile.htm", method=RequestMethod.GET)
public String Profilelist(HttpServletRequest request,ModelMap model,Customer
        customer,Profile profile, HttpServletResponse response) throws SQLException ,
        Exception{
    //Profile profile = new Profile();

    String customerName = request.getUserPrincipal().getName();

    customer = customerService.getCustomerId(customerName);
    profile = profileService.getBycustomerId(customer);
    System.out.println("cust:  "+ customer);
    System.out.println("profile:  "+ profile);
    logger.error("Viewing Profile" +customerName);
    //Customer customer = new Customer();



    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buf = new byte[1024];
    Blob blob = profile.getContent();
    InputStream in =  blob.getBinaryStream();
    System.out.println("id content" +in);
    int n = 0;
    while ((n=in.read(buf))>=0)
    {
        baos.write(buf, 0, n);

    }

    in.close();
    byte[] bytes = baos.toByteArray();
    System.out.println("bytes" +bytes);
    byte[] encodeBase64 = Base64.encodeBase64(buf);
    String base64Encoded = new String(encodeBase64, "UTF-8");


    customer.setEmailId(customerName);
    profile.setCustomer(customer);
    //profile.setContent(blob);
    System.out.println();
    profile = profileService.findProfileById(customer);
    model.addAttribute("content",base64Encoded);
    model.addAttribute("profile", profile);
    return "myProfile";
}