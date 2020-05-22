XMLStreamReader reader;

void parseRoot() {
    reader.require(START_ELEMENT, null, "root");

    while (reader.nextTag() == START_ELEMENT) {
        switch (reader.getLocalName()) {
        case "MailNotification":
            MailNotification mail = parseMail();
            // do something with mail
            break;
        // more cases
        }
    }

    reader.require(END_ELEMENT, null, "root");
}

MailNotification parseMail() {
    reader.require(START_ELEMENT, null, "MailNotification");
    MailNotification mail = new MailNotification();

    while (reader.nextTag() == START_ELEMENT) {
        switch (reader.getLocalName()) {
        case "To":
            mail.setTo(parseString());
            break;
        // more cases
        }
    }

    reader.require(END_ELEMENT, null, "MailNotification");
    return mail;
}

String parseString() {
    String text = "";
    if (reader.next() == CHARACTERS) {
        text = reader.getText();
        reader.next();
    }
    return text;
}