final StringBuilder sb = new StringBuilder();
for (int i = 0; i < msg.length; i++) {

    sb.append("SentDate : " + msg[i].getSentDate() + "\n" + "From : " + msg[i].getFrom()[0] + "\n" + "Subject : " + msg[i].getSubject() + "\n" + "Message : " + "\n" + msg[i].getContent().toString());

}
jTextArea1.setText(sb.toString());