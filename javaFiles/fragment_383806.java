**publisherQueue.put(messageObject);**
                System.out.println("Queued message no " +         messageObject.getMessage());
                System.out.println("Actual number of messages in buffer:     " + publisherQueue.size());
                for (subscriber subscriber : subscribers) {
                    subscriber.subscriberQueue.put(messageObject);
                }
                **publisherQueue.take();**