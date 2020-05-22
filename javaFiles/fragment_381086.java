component.add( new AbstractDefaultAjaxBehavior() {

        @Override
        protected void respond(AjaxRequestTarget target) {
            // your code here
        }

        @Override
        public void renderHead(IHeaderResponse response) {
            super.renderHead( response );
            response.renderOnDomReadyJavascript( getCallbackScript().toString() );
        }

        }