public class MyJsp {

    public void doPost(HttpServletRrequest request, HttpServletResponse response) {
      /* tons of code compiled off JSP */
      sendSMS(...)
    }

    private void sendSMS(String nickName, String setAnmae...) {

        String acctInfo="xxx";

        response.sendRedirect(...); // error, there is no response object in the local context
    }

}