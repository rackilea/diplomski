@Headers({"Content-Type: application/x-www-form-urlencoded"})
public interface CampaignTrigger {

    @RequestLine("POST /event?actid={actid}&key={key}&event={event}&visit={visit}")
    TriggerResponse trigger(@Param(value="visit", expander = JSONExpander.class) Map<String, String> visit, @Param("actid") String actid, @Param("key") String key, @Param("event") String event);
}

static final class JSONExpander implements Param.Expander {
    @Override
    public String expand(Object value) {
         // convert value to json string and return it.
        return xxxx;
    }
}