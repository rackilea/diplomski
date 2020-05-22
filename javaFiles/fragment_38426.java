int numPersons = personList.size();
List<GradeInfo> gradeInfos = new ArrayList<GradeInfo>();
for (int x = 0; x < numPersons; x++)
{
    GradeInfo newGradeInfo = new GradeInfo();
    gradeInfos.add(newGradeInfo);

    newGradeInfo.setStudentID(inputFile.nextInt());
    inputFile.nextLine();

    newGradeInfo.setFullName(inputFile.nextLine());

    testScore = inputFile.nextDouble();
    newGradeInfo.setTestScore(testScore);
    newGradeInfo.setGrade(testScore);

    averageScore = averageScore + testScore;
}