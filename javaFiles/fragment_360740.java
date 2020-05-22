@FXML
 private void dump(ActionEvent e) {

    try {
             if (e.getSource() == spriteDumpMI) {

                progressBar.setVisible(true);
                progressI.setVisible(true);

                progressBar.progressProperty().unbind();
                progressBar.progressProperty().bind(task.progressProperty());

                progressI.progressProperty().unbind();
                progressI.progressProperty().bind(task.progressProperty());

                progressText.textProperty().unbind();
                progressText.textProperty().bind(task.messageProperty());
                progressText.setFill(Color.GREEN);

                Task task = new Task<Boolean>() {

                  @Override
                  protected Boolean call() throws Exception {
                        updateMessage("In Progress");

                        try (Cache cache = new Cache(FileStore.open(Constants.CACHE_PATH))) {
                                ReferenceTable table = ReferenceTable.decode(Container
                                            .decode(cache.getStore().read(255, 8)).getData());
                                long count;
                                for (int i = 0; i < table.capacity(); i++) {
                                      if (table.getEntry(i) == null)
                                            continue;

                                      Container container = cache.read(8, i);
                                      Sprite sprite = Sprite.decode(container.getData());

                                      File dir = new File(Constants.SPRITE_PATH);

                                      if (!dir.exists()) {
                                            dir.mkdir();
                                      }

                                      for (int frame = 0; frame < sprite.size(); frame++) {
                                            count++;
                                      }

                                }

                                int current;
                                for (int i = 0; i < table.capacity(); i++) {
                                      if (table.getEntry(i) == null)
                                            continue;

                                      Container container = cache.read(8, i);
                                      Sprite sprite = Sprite.decode(container.getData());

                                      File dir = new File(Constants.SPRITE_PATH);

                                      if (!dir.exists()) {
                                            dir.mkdir();
                                      }

                                      for (int frame = 0; frame < sprite.size(); frame++) {
                                            File file = new File(Constants.SPRITE_PATH,
                                                        i + "_" + frame + ".png");
                                            BufferedImage image = sprite.getFrame(frame);

                                            ImageIO.write(image, "png", file);
                                            current++;
                                            updateProgress(current, count);
                                      }

                                }
                                updateMessage("Complete!");
                                Platform.runLater(() -> {
                                    progressText.setFill(Color.GREEN);
                                });
                          } catch (FileNotFoundException e1) {
                                e1.printStackTrace();
                                updateMessage("failed!");
                                Platform.runLater(() -> {
                                    progressText.setFill(Color.GREEN);
                                });
                          } catch (IOException e1) {
                                e1.printStackTrace();
                                updateMessage("failed!");
                                Platform.runLater(() -> {
                                    progressText.setFill(Color.GREEN);
                                });
                          }
                        return true;

                      }

                };

          }
          task.setOnSucceeded(e ->{
                progressBar.setVisible(false);
                progressI.setVisible(false);
                progressText.setText("");
          });
          task.setOnFailed(e ->{
                progressBar.setVisible(false);
                progressI.setVisible(false);
                progressText.setText("");
          });

          new Thread(task).start();
    } catch (Exception ex) {
          ex.printStackTrace();
    }