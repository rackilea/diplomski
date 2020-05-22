ArrayList<Status> statuses = new ArrayList<>();
int pageno = 1;
while(true) {
    try {
        System.out.println("getting tweets");
        int size = statuses.size(); // actual tweets count we got
        Paging page = new Paging(pageno, 200);
        statuses.addAll(twitter.getUserTimeline(screenName, page));
        System.out.println("total got : " + statuses.size());
        if (statuses.size() == size) { break; } // we did not get new tweets so we have done the job
        pageno++;
        sleep(1000); // 900 rqt / 15 mn <=> 1 rqt/s
        }
    catch (TwitterException e) {
        System.out.println(e.getErrorMessage());
        }
    } // while(true)