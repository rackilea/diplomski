ArrayList<GradeInfo> list = new ArrayList<GradeInfo>();
    for(int i = 0; i < 10; i++)
    {
        GradeInfo gInfo = new GradeInfo();
        list.add(gInfo);
    }

    int testScore;
    ArrayList<GradeInfo> list = new ArrayList<GradeInfo>();
    for(int x = 0; x < list.size(); x++)
    {

        list.get(x).setStudentID(inputFile.nextInt());
        inputFile.nextLine();
        list.get(x).setFullName(inputFile.nextLine();
        testScore = inputFile.nextDouble();
        list.get(x).setTestScore(testScore);
        list.get(x).setGrade(testScore);
        averageScore = averageScore + testScore;


    }