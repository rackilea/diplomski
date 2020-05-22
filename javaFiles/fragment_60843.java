public class SearchResultsView extends VerticalLayout implements View {

    public static final String NAME = "results";

    SearchResultsView(String search, String brandToSearch, String instrumentTypeToSearch,
            String usedStatusToSearch, String productTypeToSearch){

        Authentication localAuth = (Authentication) UI.getCurrent().getSession().getAttribute("AUTH");
        User user = localAuth.getUser();

        Label labelTitle = new Label("Search results");
        labelTitle.setStyleName(ValoTheme.LABEL_BOLD);
        labelTitle.addStyleName(ValoTheme.LABEL_COLORED);
        labelTitle.addStyleName(ValoTheme.LABEL_LARGE);

        addComponent(labelTitle);
        setComponentAlignment(labelTitle, Alignment.TOP_LEFT);

        if(brandToSearch == null) {
            brandToSearch = "All";
        }

        if(instrumentTypeToSearch == null) {
            instrumentTypeToSearch = "All";
        }


        if(productTypeToSearch == null) {
            productTypeToSearch = "All";
        }

        if(usedStatusToSearch == null) {
            usedStatusToSearch = "0";
        }
        else {
            switch(usedStatusToSearch) {
            case "All":
                usedStatusToSearch = "0";
                break;
            case "Used":
                usedStatusToSearch = "true";
                break;
            case "Not used":
                usedStatusToSearch = "false";
                break;
            default:
                usedStatusToSearch = "0";
                break;
            }
        }

        Boolean searchStringIsVoid = true;
        if(!search.isEmpty()) {
            searchStringIsVoid = false;
        }

        List<Product> queryResults = new ArrayList<Product>();

        try {
            queryResults = dao.QueriesDAO.getProducts(searchStringIsVoid, search, brandToSearch, instrumentTypeToSearch, usedStatusToSearch, productTypeToSearch);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        for(Product product : queryResults) {

            int cols = 2;
            int rows;

            switch(product.getProductType()) {
                case "s":
                    rows = 11;
                    break;
                case "p":
                    rows = 10;
                    break;
                case "c":
                    rows = 9;
                    break;
                default:
                    rows = 9;
                    break;
            }

            GridLayout productGrid = new GridLayout(cols, rows);
            productGrid.setSizeFull();
            productGrid.setMargin(true);

            Panel productInfo = new Panel();

            Label productName = new Label(product.getNome());
            productName.setStyleName("gridlayout-slot");
            productName.addStyleName(ValoTheme.LABEL_BOLD);
            productName.addStyleName(ValoTheme.LABEL_H3);
            productGrid.addComponent(productName, 0, 0, cols - 1, 0);

            Label description = new Label("Description");
            description.addStyleName(ValoTheme.LABEL_BOLD);
            productGrid.addComponent(description, 0, 1);
            TextArea descriptionText = new TextArea();
            descriptionText.setWidth(100, Unit.PERCENTAGE);
            descriptionText.setValue(product.getDescrizione());
            descriptionText.setReadOnly(true);
            productGrid.addComponent(descriptionText, 1, 1);

            Label weight = new Label("Weight");
            weight.setStyleName(ValoTheme.LABEL_BOLD);
            productGrid.addComponent(weight, 0, 2);
            String peso = String.valueOf(product.getPeso()) + " Kg";
            productGrid.addComponent(new Label(peso), 1, 2);

            Label brand = new Label("Brand");
            brand.setStyleName(ValoTheme.LABEL_BOLD);
            productGrid.addComponent(brand, 0, 3);
            productGrid.addComponent(new Label(product.getMarca().toString()), 1, 3);

            Label instrType = new Label("Instrument type");
            instrType.setStyleName(ValoTheme.LABEL_BOLD);
            productGrid.addComponent(instrType, 0, 4);
            productGrid.addComponent(new Label(product.getClassificazione().toString()), 1, 4);

            Label usedStatus = new Label("Used status");
            usedStatus.setStyleName(ValoTheme.LABEL_BOLD);
            productGrid.addComponent(usedStatus, 0, 5);
            String usedString = (product.isUsato()) ? "Used" : "Not used";
            productGrid.addComponent(new Label(usedString), 1, 5);

            Label date = new Label("Insertion date");
            date.setStyleName(ValoTheme.LABEL_BOLD);
            productGrid.addComponent(date, 0, 6);
            productGrid.addComponent(new Label(product.getDataInserimento().toString()), 1, 6);

            Label price = new Label("Price");
            price.setStyleName(ValoTheme.LABEL_BOLD);
            productGrid.addComponent(price, 0, 7);
            java.util.Formatter unitaryPrice = new java.util.Formatter();
            String priceToString = unitaryPrice.format("%.2f", product.getPrezzo()).toString() + " €";
            productGrid.addComponent(new Label(priceToString), 1, 7);
            unitaryPrice.close();

            if(product.getProductType().equals("p")) {
                //rows == 10

                Label applicableDiscount = new Label("Applicable discount");
                applicableDiscount.setStyleName(ValoTheme.LABEL_BOLD);
                productGrid.addComponent(applicableDiscount, 0, rows - 2);

                String discountValueToString = String.valueOf(product.getSconto()) + "%";
                Label applicableDiscountValue = new Label(discountValueToString);
                productGrid.addComponent(applicableDiscountValue, 1, rows - 2);

            }
            else if(product.getProductType().equals("s")) {
                //rows == 11

                Label levelSuggested = new Label("Suggested level");
                levelSuggested.setStyleName(ValoTheme.LABEL_BOLD);
                productGrid.addComponent(levelSuggested, 0, rows - 3);

                String levelSuggestedValueToString = product.getLivelloConsigliato().toString();
                Label levelSuggestedValue = new Label(levelSuggestedValueToString);
                productGrid.addComponent(levelSuggestedValue, 1, rows - 3);

                Label applicableDiscount = new Label("Applicable discount");
                applicableDiscount.setStyleName(ValoTheme.LABEL_BOLD);
                productGrid.addComponent(applicableDiscount, 0, rows - 2);

                String discountValueToString = String.valueOf(product.getSconto()) + "%";
                Label applicableDiscountValue = new Label(discountValueToString);
                productGrid.addComponent(applicableDiscountValue, 1, rows - 2);

            }

            Button addToCart = new Button("Add to cart");
            addToCart.addClickListener(e -> {
                user.getShoppingCart().addToCart(product);
                localAuth.setUser(user);
                UI.getCurrent().getSession().setAttribute("AUTH", localAuth);
                UI.getCurrent().getNavigator().navigateTo(CartView.NAME);
            });
            addToCart.setStyleName(ValoTheme.BUTTON_FRIENDLY);
            addToCart.addStyleName(ValoTheme.BUTTON_ICON_ALIGN_RIGHT);
            addToCart.setIcon(VaadinIcons.PLUS_CIRCLE_O);
            productGrid.addComponent(addToCart, 0 , rows - 1, 1, rows - 1);

            productInfo.setContent(productGrid);

            productInfo.setSizeFull();

            addComponent(productInfo);
        }

    }

}