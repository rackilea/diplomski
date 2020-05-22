public class SurveySentimentModel {
        public static String delimiter = "|||"; 
        private List<SurveyModel> scores = new ArrayList();
        private List<SurveyModel> negativeData = new ArrayList();
        private List<SurveyModel> positiveData = new ArrayList();


        public void setSurveyData(String Id, String comment, double score, String grade) {
            SurveyModel survey =  new SurveyModel(id, comment, score, grade );
            scores.add(survey)
            if(score >= 0){
              positiveData.add(survey);
            }else{
              negativeData.add(survey);
            }
        }
        public double getTotalScore() {
            double sum = 0;
            for(SurveyModel s: scores){
                sum += s.getScore();
            }
            return sum;
        }
        public List getSurveyData() {
            List<SurveyModel> joined = new ArrayList(negativeData);
            joined.addAll(positiveData)
            return joined;
        }
    }