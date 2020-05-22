Callback<TableColumn<Trade, String>, TableCell<Trade, String>> cellFactory
    = new Callback<TableColumn<Trade, String>, TableCell<Trade, String>>()
    {
        public TableCell call( TableColumn<Trade, String> p )
        {
            return new EditingItemIDCell();
        }
    };