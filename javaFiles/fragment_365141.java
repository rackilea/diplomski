private static class FakeTextMessage implements TextMessage {
            public FakeTextMessage(Message m) { this.childMessage = m; }
            private String text;
            private Message childMessage;
            public void setText(String t) { this.text = t; }
            public String getText() { return this.text; }

            // All the rest of the methods are simply pass-through
            // implementations of the rest of the interface, handing off to the child message.
            public void acknowledge() throws JMSException { this.childMessage.acknowledge(); }
            public void clearBody() throws JMSException { this.childMessage.clearBody(); }
            public void clearProperties() throws JMSException { this.childMessage.clearProperties(); }
            public Enumeration getPropertyNames() throws JMSException { return this.childMessage.getPropertyNames(); }
            public boolean propertyExists(String pn) throws JMSException { return this.childMessage.propertyExists(pn); }

            // and so on and so on
    }