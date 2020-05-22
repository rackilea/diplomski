static interface IGradeElementVisitor {
    String visit(ExamRecord er);

    String visit(StudentData sd);

    String visit(SchoolData sd);
}

static interface IGradeElement {
    void accept(IGradeElementVisitor igev);
}

static class GradeElementVisitor implements IGradeElementVisitor {

    @Override
    public String visit(ExamRecord er) {
        StringBuilder sb = new StringBuilder();
        DateFormat df = new SimpleDateFormat("M/d/yyyy");
        sb.append(df.format(er.date)).append(",");
        sb.append(er.grade);
        return sb.toString();
    }

    @Override
    public String visit(StudentData sd) {
        StringBuilder sb = new StringBuilder();
        sb.append(sd.name).append(",");
        return sb.toString();
    }

    @Override
    public String visit(SchoolData sd) {
        StringBuilder sb = new StringBuilder();
        for (StudentData student : sd.students) {
            for (ExamRecord er : student.records) {
                sb.append(sd.name);
                sb.append(",");
                sb.append(visit(student));
                sb.append(visit(er));
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

}

static class ExamRecord implements IGradeElement {
    public ExamRecord(Date date, String grade) {
        this.date = date;
        this.grade = grade;
    }

    Date date;
    String grade;

    public void accept(IGradeElementVisitor igev) {
        igev.visit(this);
    }
}

static class StudentData implements IGradeElement {
    public StudentData(String name, List<ExamRecord> records) {
        this.name = name;
        this.records = records;
    }

    String name;
    List<ExamRecord> records;

    public void accept(IGradeElementVisitor igev) {
        igev.visit(this);
    }
}

static class SchoolData implements IGradeElement {
    public SchoolData(String name, List<StudentData> students) {
        this.name = name;
        this.students = students;
    }

    String name;
    List<StudentData> students;

    public void accept(IGradeElementVisitor igev) {
        igev.visit(this);
    }
}

public static void main(String[] args) {
    List<ExamRecord> dans = new ArrayList<>();
    dans.add(new ExamRecord(new Date(2001, 2, 2), "A"));
    dans.add(new ExamRecord(new Date(2001, 2, 3), "B"));
    dans.add(new ExamRecord(new Date(2001, 2, 3), "A"));
    dans.add(new ExamRecord(new Date(2001, 2, 5), "C"));

    List<ExamRecord> kims = new ArrayList<>();
    kims.add(new ExamRecord(new Date(2001, 2, 5), "A"));
    kims.add(new ExamRecord(new Date(2001, 2, 5), "B"));
    List<ExamRecord> alexs = new ArrayList<>();
    alexs.add(new ExamRecord(new Date(2001, 0, 5), "A"));

    StudentData dan = new StudentData("dan", dans);
    StudentData kim = new StudentData("kim", kims);
    StudentData alex = new StudentData("alex", alexs);
    List<StudentData> bakers = new ArrayList<>();
    bakers.add(dan);
    bakers.add(kim);
    List<StudentData> thompsons = new ArrayList<>();
    thompsons.add(alex);
    List<SchoolData> schools = new ArrayList<>();
    schools.add(new SchoolData("baker elementary", bakers));
    schools.add(new SchoolData("thompson middle school", thompsons));
    IGradeElementVisitor visitor = new GradeElementVisitor();
    for (SchoolData school : schools) {
        System.out.print(visitor.visit(school));
    }
}