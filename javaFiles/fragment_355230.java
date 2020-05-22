public static void main (String [] args)
{
    double examMarks [] = {50,40,60,80,70,11};
    double courseworkmarks [] = {65,49,58,77,35,40};
    System.out.println ("These are the exam marks and the course work marks");//First row is the exam marks, second row is the course work marks
    computeMarks (examMarks);
    computeMarks1 (courseworkmarks);
    System.out.println ("These are the final marks");
    computeResults(examMarks, courseworkmarks);
}

public static void computeMarks(double[] examMarks)
{
    for (int row=0;row<examMarks.length;row++){
            System.out.print (examMarks[row] +"\t");
        }
    System.out.println();
    }
public static void computeMarks1(double[] courseworkmarks)
{
    for (int row=0;row<courseworkmarks.length;row++){
            System.out.print (courseworkmarks[row] +"\t");
        }
    System.out.println("\n");
    }


public static void computeResults(double[] examMarks, double[] courseworkmarks)
{

        double avgMarks[] =new double[examMarks.length];

        for(int i=0;i<avgMarks.length;i++){
        int cwWeighting=40;
            avgMarks[i]=(examMarks[i]*(100-cwWeighting)+courseworkmarks[i]*cwWeighting)/100;

        System.out.print (avgMarks[i] +"\t");
        }
}