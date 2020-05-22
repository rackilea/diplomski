@Override
public void validate() {
    errors = new HashMap<String, String>();

    if (StringUtil.isBlank(examCode)) {
        errors.put("examCode", "Exam code is required");
    }

    if (StringUtil.isBlank(instructions)) {
      errors.put("instructions", "Paper Instructions are required");
    }

    if (StringUtil.isBlank(strPaperType)) {
        errors.put("paperType", "Paper Type is required");
    } else {
        validatePaperType();
    }
}

public void validatePaperType() {
    paperType = PaperType.getPaperTypeByValue(strPaperType);
    if (paperType == null) {
        errors.put("paperType", "A valid Paper Type is required");
        return;
    }

    if (paperType.equals(PaperType.PRACTICE) && (topicId == null)) {
        errors.put("topicId", "Topic Id is required");
    }
}