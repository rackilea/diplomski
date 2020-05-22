beanSubject = new GsonBuilder().create().fromJson(reader, Beansubject.class);

ArrayList<BeanTopic> topicArrayList = beanSubject.getBeanTopics();

for(BeanTopic topic: topicArrayList){
                    topicList.append("* " + topic.getTitle()+"\n");
                }

txtTopicsList.setText("Topics: "+"\n" + topicList);