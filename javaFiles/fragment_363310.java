private void sendEmail(String email,String name) throws Exception{
    Thread thread=new Thread(){
        @Override
        public void run() {

            try{
                String msg="Dear<b> "+name.toUpperCase()+" </b>,<p> On Behalf of someone we would like to wish you a Many many Happy returns of the day</p> <p style=color:red;>Happy Birthday and Have a Great Day.</p>\n \n Thank You!";

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message,true);
                helper.setTo(email);
                helper.setText(msg);
                message.setContent(msg, "text/html");                   
                helper.setSubject("BirthDay");
                mailSender.send(message);

            }catch (Exception e){}
        }
    };
    thread.start();

}