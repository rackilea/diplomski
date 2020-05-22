@Transactional
    public void register() {
   //after success call that method
    emailService.sendWelcomeMail();
    }


    @Service
    @Configuration
    @EnableAsync
    public class EmailService {

        // for sending email
        @Async
        public void sendWelcomeMail(){}

    }