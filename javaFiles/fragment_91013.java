public class Broker {
    public enum Subject {Subj1, Subj2};

    static private Broker instance=null;

    HashMap<Subject,AbstractSubject> mSubjectDict;

    public static Broker getInstance()
    {
        return instance;
    }

    private Broker()
    {
        mSubjectDict=new HashMap<Subject,AbstractSubject>();
        mSubjectDict.put(Subject.Subj1,new Subject1());
        mSubjectDict.put(Subject.Subj2,new Subject2());
    }

    public AbstractLocationSubject getSubject(Subject subj)
    {
        return mSubjectDict.get(subj);
    }
}