JPanel setupPanel = new JPanel();
JPanel titlePanel = new JPanel();
JPanel contentPanel = new JPanel();
JPanel coursePanel = new JPanel();

JLabel picLabel = new JLabel(); // background of the label
picLabel.setLayout(new FlowLayout(FlowLayout.CENTER));

picLabel.setIcon(new ImageIcon(CoursesGUI.class.getResource("/images/graph_paper.jpg")));

// picLabel.setLayout(new BorderLayout()); // sets layout inside the label
JButton en_course_btn = new JButton("English Course");

contentPanel.setBackground(Color.GREEN);
titlePanel.setBackground(Color.YELLOW);

// picLabel.setPreferredSize(new Dimension(500, 470)); // dimensions of inner containers
contentPanel.setPreferredSize(new Dimension(1280, 670));
titlePanel.setPreferredSize(new Dimension(1280, 50));

picLabel.add(en_course_btn);
//coursePanel.add(en_course_btn);
coursePanel.add(picLabel);

contentPanel.add(coursePanel); // add coursePanel containing buttons and background
setupPanel.add(titlePanel, BorderLayout.NORTH);
setupPanel.add(contentPanel);
getContentPane().add(setupPanel);