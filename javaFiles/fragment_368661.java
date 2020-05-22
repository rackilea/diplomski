@Configuration
@ConfigurationProperties(prefix = "sdk")
@Validated
@NotEmptyWhenEnabled // <----- custom validation -----
@Data
class SdkProperties {

    private boolean enabled;
    private String apiKey;
}

@Constraint(validatedBy = {NotEmptyWhenEnabledValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface NotEmptyWhenEnabled {
    String message() default "SDK apiKey needed when SDK is enabled";

    Class[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

class NotEmptyWhenEnabledValidator implements ConstraintValidator<NotEmptyWhenEnabled,SdkProperties> {

    @Override
    public boolean isValid(SdkProperties sdkProperties, 
                           ConstraintValidatorContext constraintValidatorContext) {
        boolean enabled = sdkProperties.isEnabled();
        boolean empty = null == sdkProperties.getApiKey() || sdkProperties.getApiKey().isEmpty();
        return !enabled || (enabled && !empty);
    }
}