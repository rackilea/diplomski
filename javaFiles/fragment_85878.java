class UserData {
    TimeOnlineInfo timeOnlineInfo;

    public void saveData() {
        // stub
    }

    public UserData(int value) {
        this.timeOnlineInfo = new TimeOnlineInfo(value);
    }


    public class TimeOnlineInfo {
        private int time;

        public TimeOnlineInfo(int time){
            this.time = time;
        }

        public void addTime(int time){
            this.time += time;
            UserData.this.saveData();
        }
    }
}