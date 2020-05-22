distance_task.getDirectionsUrl(latLng1, latLng2);
               distance_task.setLoadListener(new CalculateDistanceTime.taskCompleteListener() {
                        @Override
                        public void taskCompleted(String[] time_distance) {
                            text1.setText(time_distance[0]); //Distance
                            text2.setText(time_distance[1]); //Time
                        }
                    });
               String url = getDirectionsUrl(latLng1, latLng2);
               DownloadTask downloadTask = new DownloadTask();
               downloadTask.execute(url);