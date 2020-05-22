public boolean validate(final BindingResult bindingResult) {
    boolean validate = true;
    for (String channel : getConfiguredChannels()) {
        switch (channel) {
        case "SMS":
            // do nothing
            break;
        case "Email":
            // do nothing
            break;
        case "Facebook":
            // do nothing
            break;
        case "Voice":
            validate = validateVoice(bindingResult);
        default:
            throw new IllegalStateException("Unsupported channel: "
                    + channel);
        }
    }
    return validate;
}