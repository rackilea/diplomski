JasperViewer jv;
JasperPrint print;
public void action() {
  button.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        report.addColumn(...);
        ...
        ...
        print=report.toJasperPrint();
        jv=new JasperViewer(print,false);
        jv.setVisible(true);
      }
    }
  });
}