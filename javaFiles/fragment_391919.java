private void execute(String URL, String keyword, ObservableList<QMITResult> dataPriority) throws Exception {

        /* Download HTML page and create list of URLs from relevant links */
        Elements links = getLinkList(URL);

        List<QMITResult> qmitResults = new ArrayList<>();

        new Thread(() -> {
            for (Element link : links) {
                try {

                    /* Create a list of formatted URLs to loop through */
                    String linkText = link.toString();
                    String titleText = link.text();
                    String formattedLink = StringUtils.substringBetween(linkText, "<a href=\"", "\"").replace("\\", "/");

                    System.out.println(titleText);
                    System.out.println(formattedLink);

                    /* Create Word Document for each link and parse for keyword */
                    QMITResult qmitResultNode = null;
                    try {
                        qmitResultNode = parseDocument(keyword, formattedLink, titleText);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    qmitResults.add(qmitResultNode);
                    dataPriority.add(qmitResultNode);
                    Thread.sleep(200);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        tableView.setItems(dataPriority);

    }