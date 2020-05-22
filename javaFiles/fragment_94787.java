static class  MediaPlayer{
        String event;
        String action;
        int timestamp;
        public MediaPlayer(String event, String action,int timestamp){
            this.event=event;
            this.action=action;
            this.timestamp=timestamp;
        }
        public String getEvent(){
            return event;
        }
        public String getAction(){
            return action;
        }
        public int getTimeStamp(){
            return timestamp;
        }
    }