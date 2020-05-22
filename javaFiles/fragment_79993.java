public class RegisterAction extends ActionSupport {
  private String userId;
  private String userEmail1;
  private String userEmail2;
  private String userPassword1;
  private String userPassword2;

  private String captchaResponse;
  private InputStream inputStream;

  //getters and setters

  public String create() {
    //RegisterAction is the form bean of the current action and captchaResponse is the field of user input

    String answer = (String) ActionContext.getContext().getSession().get("CorrectAnswer");
    if (answer == null || getCaptchaResponse()==null || !answer.equals(getCaptchaResponse())){
      addFieldError("captchaResponse", getText("error.captcha"));
    }
    return SUCCESS;
  }

  @Action(value = "captcha", results = {@Result(type="stream", params = {"contentType", "image/jpeg"})})
  public String captcha() {
    try {
      Captcha captcha = new Captcha.Builder(200, 50).addText(new DefaultTextProducer()).gimp(new DropShadowGimpyRenderer()).build();
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      //write the image
      CaptchaServletUtil.writeImage(outputStream, captcha.getImage());
      //store the answer for this in session
      ActionContext.getContext().getSession().put("CorrectAnswer", captcha.getAnswer());
      //return image
      inputStream = new ByteArrayInputStream(outputStream.toByteArray());
      return SUCCESS;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    }

  }

}