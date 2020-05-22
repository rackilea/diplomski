public class Test {

    public static void main(String[] args) {

        AttendanceRecord attendanceRecord = new AttendanceRecord();

        //There are hardcoded. You will have to substitute with your code 
        //when you read the file
        attendanceRecord.addToRecord("ConferenceA", "Jhon");
        attendanceRecord.addToRecord("ConferenceA", "Joe");
        attendanceRecord.addToRecord("ConferenceA", "Mary");
        attendanceRecord.addToRecord("ConferenceB", "Jhon");
        attendanceRecord.addToRecord("ConferenceB", "Ted");
        attendanceRecord.addToRecord("ConferenceC", "Jessica");

        int[][] jaccardArray = new int[attendanceRecord.getConferencesArray().length][attendanceRecord.getParticipantsArray().length];
        setUp2dArray(jaccardArray, attendanceRecord);
        print2dArray(jaccardArray);
    }

    public static void setUp2dArray(int[][] jaccardArray, AttendanceRecord record) {
        Map<String, ArrayList> recordMap = record.getAttendanceRecordMap();

        for (String key : recordMap.keySet()) {
            ArrayList<String> attendees = recordMap.get(key);

            for (String attendee : attendees) {
                int row = findConferencePosition(key, record.getConferencesArray());
                int column = findParticipantPosition(attendee, record.getParticipantsArray());
                System.out.println("Row inside " + row + "Col inside " + column);
                jaccardArray[row][column] = 1;
            }
        }
    }

    public static void print2dArray(int[][] jaccardArray) {
        for (int i = 0; i < jaccardArray.length; i++) {
            for (int j = 0; j < jaccardArray[i].length; j++) {
                System.out.print(jaccardArray[i][j]);
            }
            System.out.println();
        }
    }

    public static int findParticipantPosition(String employee, Object[] participantArray) {
        int position = -1;

        for (int i = 0; i < participantArray.length; i++) {
            if (employee.equals(participantArray[i].toString())) {
                position = i;
                break;
            }
        }
        return position;
    }

    public static int findConferencePosition(String employee, Object[] conferenceArray) {
        int position = -1;

        for (int i = 0; i < conferenceArray.length; i++) {
            if (employee.equals(conferenceArray[i])) {
                position = i;
                break;
            }
        }
        return position;
    }
}