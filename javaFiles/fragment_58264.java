import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;
public class Control {

    private Model model;
    private View view;
    private Token lastToken;

    public Control(Model model, View view) {

        this.model = model;
        this.view = view;
        lastToken = Token.CERCLE_BLEU;

        view.createGrid(model.getRows(), model.getCols());

        view.addPropertyChangeListener(new ViewListener());
        model.addPropertyChangeListener(Model.TOKEN, new ModelListener());
        view.start();
    }

    //a listener added to view panel to listen to property  changes events
    //fired by the mouse listener of each cell
    private class ViewListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals(View.CELL_SELECTION)) {
                int row = view.getSelectedRow();
                int col = view.getSelectedCol();

                Token token = model.getToken(row, col);
                if (token == Token.VIDE) {

                    lastToken = (lastToken == Token.CERCLE_BLEU) ?
                            Token.CERCLE_ROUGE : Token.CERCLE_BLEU;
                    token = lastToken;
                }
                model.setToken(token, row, col);
            }
        }
    }

    //listener added to model to listen to token changes. used to updated view
    //when token changes
    private class ModelListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            IndexedPropertyChangeEvent iEvt = (IndexedPropertyChangeEvent)evt;
            int index = iEvt.getIndex();
            int row = index / Model.COLS;
            int col = index % Model.COLS;
            Token token = (Token) evt.getNewValue();

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {

                    view.setCell(token, row, col);
                    view.setPath(model.getPath());
                    view.refresh();
                }
            });
        }
    }
}