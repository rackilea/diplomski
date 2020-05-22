final StringBuilder sb = new StringBuilder();
for (Message message : msg) {

    sb.append("SentDate : ").
            append(message.getSentDate()).
            append("\n").
            append("From : ").
            append(message.getFrom()[0]).
            append("\n").append("Subject : ").
            append(message.getSubject()).
            append("\n").
            append("Message : ").
            append("\n").
            append(message.getContent().toString());

}
jTextArea1.setText(sb.toString());