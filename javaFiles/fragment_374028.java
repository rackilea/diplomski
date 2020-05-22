public class Controller implements ActionListener {

    View view;
    Model model;

    Controller(View v, Model m) {
        this.view = v;
        this.model = m;
        model.addModelListener(new ModelListener() {
            @Override
            public void modelCleared(Model model) {
                view.clear();
            }
        });
        view.addButtonActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        model.Clear();
        System.out.print("H");
    }
}