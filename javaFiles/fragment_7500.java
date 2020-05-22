LinkLabel myLabel = new LinkLabel("description",
        "First ${link} second", "my link", new ILinkListener() {

            private static final long serialVersionUID = 1L;

            @Override
            public void onLinkClicked() {
                // Your desired onClick action
            }
        });