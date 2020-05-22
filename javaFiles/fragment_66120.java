@Component
public class CronJobProcessor {

    //logger
    //autowired beans

    public void executeYouCronJob() {
        LOG.debug("Fetching latest results >>>");
        List<Keyword> keywords = keywordService.findOldestSearched10();
        keywordService.updateLastSearchDate(keywords);
        searchResultService.fetchLatestResults(keywords);
        LOG.debug("<<< Latest results fetched");
    }
}