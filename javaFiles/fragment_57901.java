public interface MessageVisitor {
    void visitEmail(Email email);
    void visitSms(Sms sms);
}

public abstract class Message {
    public void accept(MessageVisitor visitor);
}

public class Email extends Message {
    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visitEmail(this);
    }
}

public class Sms extends Message {
    @Override
    public void accept(MessageVisitor visitor) {
        visitor.visitSms(this);
    }
}