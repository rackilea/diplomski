public class AttendanceRecord {

    private Map<String, ArrayList> attendanceRecordMap = new LinkedHashMap<String, ArrayList>();
    private Set<String> participants = new LinkedHashSet<String>(); 
    private Set<String> conferences = new LinkedHashSet<String>(); 

    public AttendanceRecord() {
    }

    public Map<String, ArrayList> getAttendanceRecordMap() {
        return attendanceRecordMap;
    }

    public Object[] getParticipantsArray() {
        return participants.toArray();
    }

    public Object[] getConferencesArray() {

        return conferences.toArray();
    }

    public void addToRecord(String title, String employee) {

        conferences.add(title);
        participants.add(employee);

        if (attendanceRecordMap.containsKey(title)) {
            ArrayList<String> tempList = attendanceRecordMap.get(title);
            tempList.add(employee);
        } else {
            ArrayList<String> attendees = new ArrayList<String>();
            attendees.add(employee);
            attendanceRecordMap.put(title, attendees);
        }
    }
}