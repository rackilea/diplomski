public class FixedAcknowledgeMessage extends AcknowledgeMessage {
    private var _smallMessage : *;

    public function FixedAcknowledgeMessage() { }

    public function get smallMessage() : * {
        return _smallMessage;
    }

    public function set smallMessage(value : *) : void {
        _smallMessage = value;
    }   
}