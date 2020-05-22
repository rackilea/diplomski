@Configuration
class MailConfig {

    @Bean mailSender() {
        new JavaMailSenderImpl (
            defaultEncoding: 'utf-8',
            host: 'smtp.example.org',
            port: 25
        )
    }

     @Bean templateMessage() {
         new SimpleMailMessage (
             from:    'no-reply@example.org',
             subject: 'Testing message FTW!'
         )
     }
}