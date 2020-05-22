import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HomePageEmptyMessageValidator implements ConstraintValidator<HomePageEmptyMessage, EmergencyMessages> {

@Override
public void initialize(HomePageEmptyMessage homePageEmptyMessage) {
}

@Override
public boolean isValid(EmergencyMessages emergencyMessages, ConstraintValidatorContext context) {

    if (emergencyMessages == null) {
        return false;
    }

    Integer messageEnabled = emergencyMessages.getMessagesEnabled();
    if (messageEnabled != null) {
        if (messageEnabled == 1) {
            String homePageMessage =  emergencyMessages.getHomePageMessage();
            if (Util.isNullOrEmpty(homePageMessage)) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    return false;
}

}