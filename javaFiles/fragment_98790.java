new Thread(
    new Runnable()
    {
        @Override
        public void run()
        {
            if(!HistoryAdapt.hasBeenInitiated)
            {
                try
                {
                    ///Need to wait until the data to be downloaded inside HistoryAdapt so it can show the last element from the ListView here
                    HistoryParser parser = new HistoryParser();
                    parser.parse(getInputStream(HistoryAct.RSS_LINK));
                } catch (XmlPullParserException e) {
                    Log.w(e.getMessage(), e);
                } catch (IOException e) {
                    Log.w(e.getMessage(), e);
                } finally {
                    //notify that the data finished to download 
                    MainActivity.this.runOnUiThread(
                        new Runnable()
                        {
                            public void run()
                            {
                                if (!HistoryAdapt.hasBeenInitiated)
                                {
                                    m_myLastItem = HistoryAdapt.getLastElement();
                                    //set last signal into TextView
                                    mSignal.setText(m_myLastItem.getTitle());
                                }
                            }
                        }
                    );
                }
            }
        }
    }
).run();