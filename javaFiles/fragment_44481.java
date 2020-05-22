class NotesSelectionObserverImpl implements NotesSelectionObserver {

            @Override
            public void onSelectionChange(NotesSelectionContext cContext)
                throws NotesException {
            Database ndbCurrent = cContext.getDatabase();
            Document docCurrent = cContext.getDocument();

            if (ndbCurrent != null && docCurrent != null) {
                String strEMail = "";
                if (docCurrent.getItemValueString("Form").equals("Memo")
                        || docCurrent.getItemValueString("Form")
                                .equals("Reply")) {
                    strEMail = docCurrent.getItemValueString("From");
                    strEMail = parseEMail(strEMail);

                    System.out.println("EMAIL: " + strEMail);
                    ContextCommand ccCurrent = new ContextCommand(strEMail,
                            docCurrent.getItemValueString("Subject"));
                    m_State.doFeedAction(false, m_Feeds.get(Activator.FEED_CONTEXT_ID), ccCurrent);
                }

            }
        }

        @Override
        public void onUpdateAfterSelectionChange() {
            // TODO Auto-generated method stub

        }

    }