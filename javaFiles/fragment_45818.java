JProgressBar progressBar = new JProgressBar();
progressBar.setStringPainted(true);
//progressBar.setPreferredSize(new Dimension(50, 15));
progressBar.setMaximumSize(new Dimension(50, 15)); // This line instead of above line
progressBar.setMinimum(0);
progressBar.setMaximum((int) file.length());