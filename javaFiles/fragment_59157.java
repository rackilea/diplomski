public class StackOverflowSample {

    private List<Candy> candyList = new ArrayList<>();

    public StackOverflowSample() {

    }

    public StackOverflowSample(List<Candy> candyList) {
        this.candyList = candyList;
    }

    public List<String> getSortedCandies() {

        // sort candies
        candyList = candyList.stream().sorted((o1, o2) -> {
            int nameResult = o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
            if (nameResult == 0) {
                return o1.getColor().toUpperCase().compareTo(o2.getColor().toUpperCase());
            }
            return nameResult;
        }).collect(Collectors.toList());

        Translate translate = TranslateOptions.getDefaultInstance().getService();

        List<String> translatedList = Collections.synchronizedList(new LinkedList<>());

        candyList.parallelStream().forEach(c -> {
            Detection detection = translate.detect(c.toString());
            String detectedLanguage = detection.getLanguage();
            Translation translation = translate.translate(c.toString(),
                    Translate.TranslateOption.sourceLanguage(detectedLanguage),
                    Translate.TranslateOption.targetLanguage("es"));
            translatedList.add(translation.getTranslatedText());
        });

        return translatedList;
    }
}