//////////////////////////////////
// The communication interfaces
//////////////////////////////////

public interface IChatCommunicationFactory {
    public String toString();
    public IChatCommunication create();
}

public interface IChatCommunication {
    public sendChatLine(String chatLine);
    public registerChatLineReceiver(IChatLineReceiver chatLineReceiver);
}

public interface IChatLineReceiver {
    public void onChatLineReceived(String chatLine);
}

//////////////////////////////////
// The communication interface implementations
//////////////////////////////////

public class XMLChatCommunicationFactory implements IChatCommunicationFactory {
    public String toString() {
        return "XML implementation";
    }

    public IChatCommunication create() {
        return new XMLChatCommunication();
    }
}

public class XMLChatCommunication implements IChatCommunication {
    private XMLProtocolSocket socket;

    public XMLChatCommunication() {
        // set up socket
    }

    public sendChatLine(String chatLine) {
        // send your chat line
    }

    public registerChatLineReceiver(IChatLineReceiver chatLineReceiver) {
        // start thread in which received chat lines are handled and then passed to the onChatLineReceived of the IChatLineReceiver
    }
}

// Do the same as above for the Serialization implementation.


//////////////////////////////////
// The user interface
//////////////////////////////////

public void fillListBoxWithCommuncationImplementations(ListBox listBox) {
    listBox.addItem(new XMLChatCommunicationFactory());
    listBox.addItem(new SerializationChatCommunicationFactory());
}

public IChatCommunication getChatCommunicationImplementationByUserSelection(ListBox listBox) {
    if (listBox.selectedItem == null)
        return null;

    IChatCommunicationFactory factory = (IChatCommunicationFactory)listBox.selectedItem;
    return factory.create();
}