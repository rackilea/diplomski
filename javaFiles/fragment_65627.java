XListStore<SampleDTO> store = new XListStore<SampleDTO>(new ModelKeyProvider<SampleDTO>() {
        @Override
        public String getKey(SampleDTO item) {
            return item.getId();
        }
    })  {
        public boolean filter(SampleDTO item) {
            boolean result = false;
            //Write you filter logic here
            return result;
        }
    };
store.setEnableFilters(true);