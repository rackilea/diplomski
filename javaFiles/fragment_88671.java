import java.util.Arrays;
import java.util.List;

public class LevelTest {
    private static final int MAX_LEVEL_COUNT = 100;
    private final int levels[] = new int[MAX_LEVEL_COUNT];
    private int lastLevel = 1;

    public LevelTest() {
        // set all levels to 0
        cleanLevels(0, MAX_LEVEL_COUNT);
    }

    // convert the user input value to level and title (assume, that the input
    // format is "Title, Level XX")
    public void printLevel(final String levelAndTitle) {
        final String[] parts = levelAndTitle.split(", ");
        final int level = Integer.valueOf(parts[1].split(" ")[1]);
        final String title = parts[0];

        printLevel(level, title);
    }

    // prints the level with title to stdout (or an error to stderr if the
    // level is lower than 1 or two level higher than the last level)
    public void printLevel(final int level, final String title) {
        // print error if level is two level higher than last level
        if (level > lastLevel) {
            System.err.println("Level is too high!");
            return;
        }

        // clean all levels after current level, if current level is lower than
        // last level
        if (level < lastLevel) {
            cleanLevels(level, lastLevel);
        }

        // set last level to current level
        lastLevel = level + 1;

        // increment the current level number
        levels[level - 1]++;

        final StringBuffer sb = new StringBuffer();

        for (int i = 0; i < level; i++) {
            // concatenate levels
            sb.append(levels[i]).append(".");
        }

        sb.append(" ").append(title);

        // print levels and title
        System.out.println(sb);
    }

    // clean a range of levels by setting each level item to 0
    private void cleanLevels(final int fromLevel, final int toLevel) {
        for (int i = fromLevel; i < toLevel; i++) {
            levels[i] = 0;
        }
    }

    public static void main(final String[] args) {
        final LevelTest lt = new LevelTest();

        final List<String> items = Arrays.asList(new String[] {
            "History, Level 1",
            "History of America, Level 2",
            "History of California, Level 3",
            "History of New York, Level 3",
            "History of UK, Level 2",
            "History of France, Level 2",
            "Economy, Level 1",
        });

        for (final String item : items) {
            lt.printLevel(item);
        }
    }
}