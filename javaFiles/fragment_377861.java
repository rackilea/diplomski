public class NewsProviderInstanceCreator implements InstanceCreator<NewsProvider>
    {
        private int context;

        public NewsProviderInstanceCreator(int context)
        {
            this.context = context;
        }

        @Override
        public NewsProvider createInstance(Type type)
        {
            NewsProvider np = new NewsProvider(context);
            return np; 
        }

}