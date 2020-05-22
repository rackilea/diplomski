@Override
public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    Captcha captcha = new Captcha.Builder(_width, _height)
        .addText()
        .addBackground(new GradiatedBackgroundProducer())
        .gimp()
        .addNoise()
        .addBorder()
        .build();

    CaptchaServletUtil.writeImage(resp, captcha.getImage());

    req.getSession().setAttribute(NAME, captcha);
}