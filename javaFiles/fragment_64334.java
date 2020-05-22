public JAgreementPanel() 
{
    panelMain = new JPanel();
    panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
    submitterLabel = new JLabel("Submitter Name: ");
    submitterText = new JTextField("e.g: Calvin M. Cox", 30);

    panelMain.add(Box.createVerticalGlue());
    //This is where the error exists
    panelMain.add(submitterLabel);
    panelMain.add(Box.createVerticalGlue());
    //This is where the error exists
    panelMain.add(submitterText);
    panelMain.add(Box.createVerticalGlue());
  }
Whereas I should have been adding the desired content of the panel to the custom 
panel 
itself. This is the new correctly functioning code: 
public JAgreementPanel() 
    {
        panelMain = new JPanel();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        submitterLabel = new JLabel("Submitter Name: ");
        submitterText = new JTextField("e.g: Calvin M. Cox", 30);
        //this could be also written as "this.add(submitterLabel)"
        add(submitterLabel);
        add(Box.createHorizontalGlue());
        add(submitterText);
        add(Box.createHorizontalGlue());
        setVisible(true);
    }
This could also be accomplished with the code comments as well. I will also include 
the updated view constructor that is called to create the gui:
public View(Main pMain) 
{

    setMain(pMain);

    clearButton = new JButton("Clear");
    exitButton = new JButton("Exit");
    submitButton = new JButton("Submit");
    panelSecondary = new JPanel();
    panelMain = new JPanel();


    panelSecondary.setLayout(new BoxLayout(panelSecondary, BoxLayout.Y_AXIS));

    panelSecondary.add(new JAgreementPanel());

    panelSecondary.add(new JClientPanel());

    panelSecondary.add(new JJobPanel());

    panelSecondary.add(new JPaymentPanel());

    panelMain.setLayout(new GridLayout(2,1));

    panelMain.add(panelSecondary);

    JPanel panelButtons = new JPanel();

    panelButtons.add(exitButton);
    panelButtons.add(clearButton);
    panelButtons.add(submitButton);

    panelMain.add(panelButtons);


    scrollPane = new JScrollPane(panelMain);


    scrollPane.setVisible(true);

    add(panelMain);

    setTitle("G.C. Septic Services Contract Drafter");
    setSize(500, 500);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}