/**
 *
 * @author blj0011
 */
public class HandleLevenshteinDistance
{

    private List<String> dictionary = new ArrayList<>();

    public HandleLevenshteinDistance()
    {
        try {
            //Load DictionaryFrom file
            //See if the dictionary file exists. If it don't download it from Github.
            File file = new File("alpha.txt");
            if (!file.exists()) {
                FileUtils.copyURLToFile(
                        new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words_alpha.txt"),
                        new File("alpha.txt"),
                        5000,
                        5000);
            }

            //Load file content to a List of Strings
            dictionary = FileUtils.readLines(file, Charset.forName("UTF8"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public List<String> getPotentialCorretSpellings(String misspelledWord)
    {
        LevenshteinDistance levenshteinDistance = new LevenshteinDistance();
        List<CustomWord> customWords = new ArrayList();

        dictionary.stream().forEach((wordInDictionary) -> {
            int distance = levenshteinDistance.apply(misspelledWord, wordInDictionary);
            if (distance <= 2) {
                customWords.add(new CustomWord(distance, wordInDictionary));
            }
        });

        Collections.sort(customWords, (CustomWord o1, CustomWord o2) -> o1.getDistance() - o2.getDistance());

        List<String> returnList = new ArrayList();
        customWords.forEach((item) -> {
            System.out.println(item.getDistance() + " - " + item.getWord());
            returnList.add(item.getWord());
        });

        return returnList;
    }
}