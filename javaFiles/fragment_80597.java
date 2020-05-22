<sj:select name = "bean.country" 
               list = "countries" 
            listKey = "id"
          listValue = "description"
               href = "%{loadCountriesAction}"
              value = "%{bean.country}"
     onChangeTopics = "reloadState" 
   onCompleteTopics = "reloadState" />

    <sj:select name = "bean.state" 
               list = "states" 
            listKey = "id"
          listValue = "description"
               href = "%{loadStatesAction}"
              value = "%{bean.state}" 
       reloadTopics = "reloadState" 
    deferredLoading = "true" />