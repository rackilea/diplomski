String html = ""
        +"<div class='tt_details'>"
        +"    <div class='tt_day'>Mon</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_timeslot'>11:00 - 13:00"
        +"        <div class='tt_day_small'> (Mon)</div>"
        +"    </div>"
        +"    <div class='tt_detail'>Internet of Things<br/>E1010 - MAC Lab <br/></div>"
        +"    <div class='tt_lecturer'>Loftus, M</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_timeslot'>13:00 - 14:00"
        +"        <div class='tt_day_small'> (Mon)</div>"
        +"    </div>"
        +"    <div class='tt_detail'>Computer Systems & Networking<br/>A0004 - Tiered Lecture Theatre (132) <br/></div>"
        +"    <div class='tt_lecturer'>Lang, D</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_timeslot'>16:00 - 18:00"
        +"        <div class='tt_day_small'> (Mon)</div>"
        +"    </div>"
        +"    <div class='tt_detail'>Intro.to Programming L8<br/>D2005 - Computer Laboratory (32) <br/></div>"
        +"    <div class='tt_lecturer'>Kinsella,V</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_day'>Tue</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_timeslot'>09:00 - 10:00"
        +"        <div class='tt_day_small'> (Tue)</div>"
        +"    </div>"
        +"    <div class='tt_detail'>Mathematics 2<br/>A0004 - Tiered Lecture Theatre (132) <br/></div>"
        +"    <div class='tt_lecturer'>O'Regan,D</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_timeslot'>10:00 - 11:00"
        +"        <div class='tt_day_small'> (Tue)</div>"
        +"    </div>"
        +"    <div class='tt_detail'>Mathematics 2<br/>E0017 - Tiered Classroom (106) <br/></div>"
        +"    <div class='tt_lecturer'>O'Regan,D</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_timeslot'>11:00 - 12:00"
        +"        <div class='tt_day_small'> (Tue)</div>"
        +"    </div>"
        +"    <div class='tt_detail'>Intro to Programming<br/>A0006 - Tiered Lecture Theatre (152) <br/></div>"
        +"    <div class='tt_lecturer'>Kinsella,V</div>"
        +"</div>"
        +"<div class='tt_details'>"
        +"    <div class='tt_timeslot'>16:00 - 17:00"
        +"        <div class='tt_day_small'> (Tue)</div>"
        +"    </div>"
        +"    <div class='tt_detail'>Computer Systems & Networking<br/>A0006 - Tiered Lecture Theatre (152) <br/></div>"
        +"    <div class='tt_lecturer'>Lang, D</div>"
        +"</div>"
        ;
Document doc = Jsoup.parse(html);
Elements courseEls = doc.select("div.tt_details:not(:has(div.tt_day))");
class Course{
    public Course(String day, String time, String lecturer, String subject) {
        super();
        this.day = day;
        this.time = time;
        this.lecturer = lecturer;
        this.subject = subject;
    }
    public String day;
    public String time;
    public String lecturer;
    public String subject;

    public String toString(){
        return day + " : "+ time +" : "+ lecturer + " : "+ subject;
    }
}
Map<String,List<Course>> coursesByDay = new HashMap<>();
for (Element courseEl : courseEls){
    Element timeSlotEl = courseEl.select(".tt_timeslot").first();
    String timeSlotStr = timeSlotEl.ownText();
    String dayStr = timeSlotEl.select(".tt_day_small").first().text().trim().replace("(", "").replace(")", "");
    String detailStr = courseEl.select(".tt_detail").first().text();
    String lecturerStr = courseEl.select(".tt_lecturer").first().text();

    Course course = new Course(dayStr, timeSlotStr, lecturerStr, detailStr);
    List<Course> courses = coursesByDay.get(dayStr);
    if (courses == null){
        courses = new ArrayList<>();
        coursesByDay.put(dayStr, courses);
    }
    courses.add(course);
}

//get all courses on Tue
List<Course> courses = coursesByDay.get("Tue");
for (Course c : courses){
    System.out.println(c);
}