import com.vaadin.flow.data.provider.*;

DataProvider<Person, Void> dataProvider = DataProvider.fromCallbacks(
            // First callback fetches items based on a query
            query -> {
                ...
                return persons.stream();
            },
            // Second callback fetches the number of items for a query
            query -> getPersonService().getPersonCount());