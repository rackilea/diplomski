public void addEvent(VEvent event, VTimeZone timezone){
                    try {
                        Calendar calendar = new Calendar();
                        calendar.getProperties().add(new ProdId(prodId));
                        calendar.getProperties().add(Version.VERSION_2_0);
                        calendar.getProperties().add(CalScale.GREGORIAN);
                        calendar.getComponents().add(event);
                        collection.add(httpClient, calendar);
                    } catch (CalDAV4JException e) {
                        e.printStackTrace();
                    }

    }