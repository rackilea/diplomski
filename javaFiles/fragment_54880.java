@Service
    public class WidgetService {

        private WidgetCache widgetCache;

        /** or 
        private List<WidgetCache> widgetCaches;
        public WidgetService(List<WidgetCache> widgetCaches) {
            this.widgetCaches = widgetCaches;
        }
        */
        public WidgetService(@Qualifier(<desired impl>) WidgetCache widgetCache) {
            this.widgetCache = widgetCache;
        }
    }