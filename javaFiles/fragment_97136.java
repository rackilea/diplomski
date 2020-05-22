private boolean validateVoice(final BindingResult bindingResult) {
    boolean validate = true;
    final SpelExpressionParser parser = new SpelExpressionParser();
    if (parser.parseExpression("!voiceMessageForm.audioForms.?[audioId == '' || audioId == null].isEmpty()").getValue(this, Boolean.class)) {
        bindingResult.rejectValue("voiceMessageForm.audioForms", "message.voice.provide.all.audios");
        validate = false;
    }
    boolean voiceContentErrorSet = false;
    boolean voiceDescriptionErrorSet = false;
    for (AudioForm audioForm : (List<AudioForm>) parser.parseExpression("voiceMessageForm.audioForms.?[description.length() > 8000]").getValue(this)) {
        if (audioForm.getAddAudioBy().equals(AudioForm.AddBy.TTS) && !voiceContentErrorSet) {
            voiceContentErrorSet = true;
            bindingResult.rejectValue("voiceMessageForm.audioForms", "message.voice.content.exceed.limit");
        } else {
            if (!voiceDescriptionErrorSet) {
                voiceDescriptionErrorSet = false;
                bindingResult.rejectValue("voiceMessageForm.audioForms", "message.describe.voice.content.exceed.limit");
            }
        }
        validate = false;
    }
    return validate;
}