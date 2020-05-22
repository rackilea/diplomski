public class Main {

    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new FileReader(
                "C:\\path\\to\\file"))) {
            String line = br.readLine().trim(); // may throw IOException
            int num_of_sections = Integer.parseInt(line);
            List<Section> sections = new ArrayList<>(num_of_sections);
            for (int j = 1; j <= num_of_sections; ++j) {
                line = _skip_empty(br);
                int section_number = Integer.parseInt(line);
                String section_text = _skip_empty(br);
                line = _skip_empty(br);
                int num_choices = Integer.parseInt(line);
                List<Choice> choices = new ArrayList<>(num_choices);
                for (int choice = 0; choice < num_choices; ++choice) {
                    line = _skip_empty(br);
                    int go_to_section = Integer.parseInt(line);
                    String choice_text = _skip_empty(br);
                    choices.add(new Choice(go_to_section, choice_text));
                }
                sections.add(new Section(section_number, section_text, choices));
            }
        }
    }

    private static class Section {
        private final int sectionNumber;
        private final String storyText;
        private final List<Choice> choices;

        Section(int sectionNumber, String storyText, List<Choice> choices) {
            this.sectionNumber = sectionNumber;
            this.storyText = storyText;
            this.choices = choices;
        }

        public String getStoryText() {
            return storyText;
        }

        public List<Choice> getChoices() {
            return choices;
        }

        public int getSectionNumber() {
            return sectionNumber;
        }
    }

    private static class Choice {
        private final int leadsToSection;
        private final String choiceText;

        Choice(int leadsToSection, String choiceText) {
            this.leadsToSection = leadsToSection;
            this.choiceText = choiceText;
        }

        public int getLeadsToSection() {
            return leadsToSection;
        }

        public String getChoiceText() {
            return choiceText;
        }
    }

    private static String _skip_empty(BufferedReader br) throws IOException {
        String line;
        do {
            line = br.readLine();
            if (line == null) return ""; // winning choice does that
            line = line.trim();
        } while (line.isEmpty());
        return line;
    }
}