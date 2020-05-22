import java.util.Random;
public class YEAH
{
    private static final Random randomChar=new Random();
    private static String studentID[][] = new String [3][4];
    private static String studentName[][]= new String[3][4];
    private static String studentLastName[][]= new String [3][4];
    private static char key[]={'a','b','c','e','d','b','a','b','a','e'};
    private static int studentPoints[][]=new int[3][4]
    private static int studentGrades[][]=new int[3][4];  //points*10
    private static char[][][] studentAnswers = new char[3][4][10];
        //store the answers given by students

    public static void main(String[] args)
    {
        studentName[0][0]="Cagatay";
        studentName[0][1]="Serhat";
            //... your code ...
        studentID[2][2]="D3";
        studentID[2][3]="D4";
        generateRandomAnswers();
        countPoints();
        PrintResults();
    }

    private static void PrintResults() {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                System.out.Println(studentPoints[i][j] + "\t" +
                    studentID[i][j] + "\t" +
                    studentName[i][j] + "\t" +
                    studentLastName[i][j]);
            }
        }
    }

    private static void countPoints() {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    studentPoints[i][j] = 0;
                    if (studentAswers[i][j][k] == key[i][j][k])
                    {
                        studentPoints[i][j]++;
                    }
                    studentGrades[i][j] = 10 * studentPoints[i][j];
                }
            }
        }
    }

    private static void generateRandomAnswers() {
        Random rnd = new Random();
        String alphabet="abcde";
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    studentAnswers[i][j][k]=alphabet.charAt(randomChar.nextInt(5));
                }
            }
        }
    }
}