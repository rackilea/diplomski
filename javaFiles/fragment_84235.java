public class ExaminationTypesVO {
    private List<ExaminationTypeVOWrapper> examinationTypes;

    public List<ExaminationTypeVOWrapper> getExaminationTypes() {
        return examinationTypes;
    }

    public void setExaminationTypes(List<ExaminationTypeVOWrapper> examinationTypes) {
        this.examinationTypes = examinationTypes;
    }

    public static class ExaminationTypeVOWrapper {
        private final ExaminationTypeVO examinationTypeVO;

        @JsonCreator
        public ExaminationTypeVOWrapper(@JsonProperty("ExaminationTypeVO") ExaminationTypeVO examinationTypeVO) {
            this.examinationTypeVO = examinationTypeVO;
        }

        public ExaminationTypeVO getExaminationTypeVO() {
            return examinationTypeVO;
        }
    }
}