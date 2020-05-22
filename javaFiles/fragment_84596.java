ResponseList<Status> list = twitter.getHomeTimeline();
URLEntity[] uent = list.get(0).getURLEntities();
if (uent != null) {
                    for (int k = 0; k < uent.length; k++) {
                        Log.i("URL Entity", "Dp Url " + uent[k].getDisplayURL()
                                + " URL " + uent[k].getURL() + " start "
                                + uent[k].getStart() + " end "
                                + uent[k].getEnd());
                    }
}