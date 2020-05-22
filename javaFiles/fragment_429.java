public static class Message {
        private String label;
        private String message;

        public String getMessage() {
            return message;
        }

        public String getLabel() {
            return label;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    public static enum WarningType {
        WARN, NOTIFICATION
    }

    public static class Warning {

        WarningType type;
        List<Message> messages;
        String title;

        public WarningType getType() {
            return type;
        }

        public void setType(WarningType type) {
            this.type = type;
        }

        public void setMessages(List<Message> messages) {
            this.messages = messages;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<Message> getMessages() {
            return messages;
        }

        public String getTitle() {
            return title;
        }
    }

    public static class Warnings {
        List<Map<String, Object>> warnings;

        public List<Map<String, Object>> getWarnings() {
            return warnings;
        }

        public void setWarnings(List<Map<String, Object>> warnings) {
            this.warnings = warnings;
        }

        public void setWarningsInMap(List<Warning> warningList) {
            warnings = new ArrayList<>();
            for(Warning each : warningList) {
                Map<String, Object> m = new LinkedHashMap<>();
                m.put(each.getType().name(), each.getMessages());
                m.put("title", each.getTitle());
                warnings.add(m);
            }
        }
    }

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        List<Warning> warningList = new ArrayList<>();

        Warning warn = new Warning();
        warn.setType(WarningType.WARN);

        List<Message> warnMessages = new ArrayList<>();

        Message m = new Message();
        m.setLabel("Label Goes Here");
        m.setMessage("Message Goes Here");
        warnMessages.add(m);

        m = new Message();
        m.setLabel("Label Goes Here2");
        m.setMessage("Message Goes Here2");
        warnMessages.add(m);

        warn.setMessages(warnMessages);

        warn.setTitle("Please review the following warnings");

        warningList.add(warn);

        Warning notification = new Warning();
        notification.setType(WarningType.NOTIFICATION);

        List<Message> notificationMessages = new ArrayList<>();

        m = new Message();
        m.setLabel("Label Goes Here3");
        m.setMessage("Message Goes Here3");
        notificationMessages.add(m);

        m = new Message();
        m.setLabel("Label Goes Here4");
        m.setMessage("Message Goes Here4");
        notificationMessages.add(m);

        notification.setMessages(notificationMessages);

        notification.setTitle("Please review the following warnings");

        warningList.add(notification);

        Warnings w = new Warnings();
        w.setWarningsInMap(warningList);

        String s = new ObjectMapper().defaultPrettyPrintingWriter().writeValueAsString(w);
        System.out.println(s);
    }