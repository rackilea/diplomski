public static void main(String args[]) throws Exception {
        String MidtermLecGrade, MidtermLabGrade;

        Float temp;
        float a = 0.6f;
        float b = 0.4f;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your Midterm Lecture Grade:");
        MidtermLecGrade = br.readLine();
        System.out.print("Enter your Midterm Lab Grade:");
        MidtermLabGrade = br.readLine();

        temp = ((a * Float.parseFloat(MidtermLecGrade)) + (b * Float.parseFloat(MidtermLabGrade)));
        System.out.println("Your Midterm Grade is :" + temp);

    }