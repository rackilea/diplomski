@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    //..other code
}