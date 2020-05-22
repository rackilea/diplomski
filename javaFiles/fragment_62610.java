import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.commons.lang3.StringUtils;

public class Solution {

    private static final String ROOM_ID = "RoomID";
    private static final String CONTENT = "Content";
    private static final String LOGIN_NAME = "LoginName";
    private static final String CONVERSATION_ID = "ConversationID";
    private static final String FILE_DUMP = "FileDump";
    private static final String MESSAGE = "Message";
    private static final String CONVERSATION = "Conversation";
    private static final String START_TIME = "StartTime";

    static class ConversationInfo {
        private String startTimeStr;

        private String conversationId;

        private final Set<String> users = new HashSet<>();

        private final List<Message> messages = new ArrayList<>();

        @Override
        public String toString() {
            return String.format("%s %s (%d) %s", startTimeStr, conversationId, users.size(),
                 StringUtils.join(messages, " + "));
        }
    }

    static class Message {

        public final String userName;

        public final String content;

        public Message(String name, String content) {
            this.userName = name;
            this.content = content;
        }

        @Override
        public String toString() {
            return userName + " " + content;
        }
    }

    public static void main(String[] args)
            throws XMLStreamException, IOException {
        XMLInputFactory xf = XMLInputFactory.newFactory();
        List<ConversationInfo> m = new ArrayList<>();
        try (FileInputStream fin = new FileInputStream("input.xml")) {
            XMLStreamReader xr = xf.createXMLStreamReader(fin);
            LOOP: while (xr.hasNext()) {
                int event = xr.next();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String elName = xr.getLocalName();
                        if (CONVERSATION.equals(elName)) {
                            ConversationInfo convInfo = parseConversation(xr);
                            if (convInfo != null) {
                                m.add(convInfo);
                            }
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String elName = xr.getLocalName();
                        if (FILE_DUMP.equals(elName)) {
                            break LOOP;
                        }
                        break;
                    }
                    case XMLStreamConstants.END_DOCUMENT:
                        throw new IllegalStateException("xml not well-formed: <"
                            + FILE_DUMP + "> tag not closed");
                }
            }
        }
        try (FileWriter w = new FileWriter("output.txt")) {
            int i = 1;
            for (ConversationInfo convInfo : m) {
                w.write(String.format("%d %s\n", i++, convInfo));
            }
        }
    }

    private static ConversationInfo parseConversation(XMLStreamReader xr)
            throws XMLStreamException {
        ConversationInfo convInfo = new ConversationInfo();
        while (xr.hasNext()) {
            int event = xr.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT: {
                    String elName = xr.getLocalName();
                    if (MESSAGE.equals(elName)) {
                        Message message = parseMessage(xr);
                        if (message != null) {
                            convInfo.messages.add(message);
                            convInfo.users.add(message.userName);
                        }
                    } else if (START_TIME.equals(elName)) {
                        convInfo.startTimeStr = xr.getElementText();
                    } else if (ROOM_ID.equals(elName)) {
                        convInfo.conversationId = xr.getElementText();
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String elName = xr.getLocalName();
                    if (CONVERSATION.equals(elName)) {
                        return convInfo;
                    }
                    break;
                }
                case XMLStreamConstants.END_DOCUMENT:
                    throw new XMLStreamException("xml not well-formed: <"
                        + CONVERSATION + "> tag not closed");
            }
        }
        throw new XMLStreamException(
            "unexpected end of xml file while parsing a conversation");
    }

    private static Message parseMessage(XMLStreamReader xr)
            throws XMLStreamException {
        String userName = null;
        String content = null;
        while (xr.hasNext()) {
            int event = xr.next();
            switch (event) {
                case XMLStreamConstants.START_ELEMENT: {
                    String elName = xr.getLocalName();
                    if (LOGIN_NAME.equals(elName)) {
                        userName = xr.getElementText();
                    } else if (CONTENT.equals(elName)) {
                        content = StringUtils.trimToEmpty(xr.getElementText());
                    }
                    break;
                }
                case XMLStreamConstants.END_ELEMENT: {
                    String elName = xr.getLocalName();
                    if (MESSAGE.equals(elName)) {
                        return new Message(userName, content);
                    }
                    break;
                }
                case XMLStreamConstants.END_DOCUMENT:
                    throw new XMLStreamException("xml not well-formed: <"
                        + MESSAGE + "> tag not closed");
            }
        }
        throw new XMLStreamException(
            "unexpected end of xml file while parsing a message");
    }
}