public synchronized ModelAndView submitRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    LOG.debug("submitRegister: " + this.toString);
    EmailUtility.sendEmail("a@x.y", "b@x.y", "subject", "message", "from", "to");
}

public static boolean sendEmail(String fromAddress, String to, String subject, String message, String fromHeaderValue, String toHeaderValue) {
    LOG.debug("sendEmail: " + this.toString());
}