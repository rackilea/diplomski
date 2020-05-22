new TreeSet<ExamObject>(new Comparator<ExamObject>(){

    @Override
    public int compare(ExamObject a, ExamObject b){
        int q1 = 0, q2 = 0;
        if(a instanceof ExamQuestion){
            q1 = ((ExamQuestion)a).questionNumber;
            if(b instanceof ExamQuestion){
                q2 = ((ExamQuestion)b).questionNumber;
            }else{
                q2 = ((ExamTask)b).id;
            }
        }else{
            q1 = ((ExamTask)a).id;
            if(b instanceof ExamQuestion){
                q2 = ((ExamQuestion)b).questionNumber;
            }else{
                q2 = ((ExamTask)b).id;
            }
        }
        if(q1 == q2) return 0;
        else return q1 < q2  ? -1 : 1;
    }
});