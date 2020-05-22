public List<ScoreCategorizedWithMonth> scoreCategorizeWithMonths(Long userId) {
        List<ScoreCategorizedWithMonth> monthCategory = scoreDao.scoreCategorizeWithMonths(userId);
        List<ScoreCategorizedWithMonth> result = new ArrayList<>();
        for (int i=1; i<=12;i++)
        {
            ScoreCategorizedWithMonth scoreCategorizedWithMonth = checkMonthCatIsExist(i, monthCategory);
            result.add(scoreCategorizedWithMonth);
        }
        return result;
    }

    private ScoreCategorizedWithMonth checkMonthCatIsExist(int month, List<ScoreCategorizedWithMonth> monthCategory) {
        for (ScoreCategorizedWithMonth cat:monthCategory) {
            if(cat.getMonth() == month){
                return cat;
            }
        }
        ScoreCategorizedWithMonth temp= new  ScoreCategorizedWithMonth();
        temp.setMonth(month);
        temp.setScores(0);
        return temp;
    }