navigator.addViewChangeListener(new ViewChangeListener() {

        @Override
        public boolean beforeViewChange(ViewChangeEvent event) {
            // check you're happy to change

            if (ViewTokens.AVAILABLE_TOKENS.contains(navigationState)) {
                if (viewProvider.getView(event.getViewName()) == null) {
                    String uriFragment = parseViewToken();
                    if (uriFragment.equals(event.getViewName())) {
                        navigator.navigateTo(ViewTokens.HOME);
                        return false;
                    }
                } else {
                    // if nothing found, redirect
                    navigator.navigateTo(ViewTokens.HOME);
                    return false;
                }
                // Let the view change happen.
                return true;
            }

        }

        @Override
        public void afterViewChange(ViewChangeEvent event) {

        }
    });