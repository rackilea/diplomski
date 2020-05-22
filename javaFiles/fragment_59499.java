@Getter
@RequiredArgsConstructor
public enum WaitConditionForWebElements {

    allPresenceExtended(CustomExpectedCondition::moreThanOne);

    private final Function<By, ExpectedCondition<List<WebElement>>> type;

}