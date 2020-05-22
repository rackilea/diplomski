List<StatisticsDetails> statisticsDetailsList = new ArrayList<StatisticsDetails>();
        for (String queueName : qName) {
            StatisticsDetails details = new StatisticsDetails();
            String[] splitQueues = queueName.split("=");
            details.setqKey(splitQueues[0]);
            details.setqCount(splitQueues[1]);
            statisticsDetailsList.add(details);
        }
        statisticsDetails.setqNamesList(statisticsDetailsList);
        request.setAttribute("key",statisticsDetails);
        RequestDispatcher rd = request.getRequestDispatcher("target.jsp");
        rd.forward(request, response);