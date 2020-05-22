public class CourseGrades implements Analyzable {

    private GradedActivity[] grades = new GradedActivity[4];

    public CourseGrades(GradedActivity lab, PassFailExam score, Essay essay, FinalExam finalExam){

        setLab(lab);
        setPassFailExam(score);
        setEssay(essay);
        setFinalExam(finalExam);

    }

    public void setLab(GradedActivity g){
        this.grades[0] = g;
    }
    public void setPassFailExam(PassFailExam g){
        this.grades[1] = g;
    }
    public void setEssay(Essay g){
        this.grades[2] = g;
    }
    public void setFinalExam(FinalExam g){
        this.grades[3] = g;
    }