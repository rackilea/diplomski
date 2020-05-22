import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Modules extends BorderPane {
    private final Button Term1AddBtn, Term1RemoveBtn, Term2AddBtn, Term2RemoveBtn, ResetBtn, SubmitBtn;
    private final ListView Term1UnSelect, Term2UnSelect, Term1Select, Term2Select, YearSelect;
    private final TextField txtTerm1Cred;

    public Modules() {
        HBox rootHBox = new HBox();

        this.setPadding(new Insets(0, 10, 20, 10)); 

        Label lblTerm1UnSel = new Label("Unselected Term 1 Modules");
        Label lblTerm2UnSel = new Label("Unselected Term 2 Modules");
        Label lblTerm1Sel   = new Label("Selected Term 1 Modules");
        Label lblTerm2Sel   = new Label("Selected Term 2 Modules");
        Label lblYearSel   = new Label("Selected Year Long Modules");
        Label lblTerm1Btns  = new Label("Term 1:");
        Label lblTerm2Btns  = new Label("Term 2:");
        Label lblTerm1Cred  = new Label("Current Term 1 Credits:");
        Label lblTerm2Cred  = new Label("Current Term 2 Credits:");

        Term1UnSelect = new ListView();
        Term2UnSelect = new ListView();
        Term1Select = new ListView();
        Term2Select = new ListView();
        YearSelect = new ListView();
        Term1AddBtn  = new Button("Add");
        Term1RemoveBtn   = new Button("Remove");
        Term2AddBtn  = new Button("Add");
        Term2RemoveBtn   = new Button("Remove");
        ResetBtn    = new Button("Reset");
        SubmitBtn    = new Button("Submit");
        txtTerm1Cred = new TextField("0");


        Term1UnSelect.setPrefSize(350, 100);
        Term2UnSelect.setPrefSize(350, 100);
        Term1Select.setPrefSize(350, 100);
        Term2Select.setPrefSize(350, 100);
        YearSelect.setPrefSize(350, 50);
        txtTerm1Cred.setMaxWidth(50);
        txtTerm1Cred.setMaxWidth(50);
        Term1AddBtn.setPrefWidth(70);
        Term1RemoveBtn.setPrefWidth(70);
        Term2AddBtn.setPrefWidth(70);
        Term2RemoveBtn.setPrefWidth(70);
        ResetBtn.setPrefWidth(70);
        SubmitBtn.setPrefWidth(70);

        VBox vboxTerm1Unsel = new VBox();
        VBox vboxTerm2Unsel = new VBox();
        VBox vboxTerm1Sel   = new VBox();
        VBox vboxTerm2Sel   = new VBox();
        VBox vboxYear   = new VBox();
        HBox hboxTerm1Btns  = new HBox();
        HBox hboxTerm2Btns  = new HBox();
        HBox hboxTerm1Cred  = new HBox();
        HBox hboxTerm2Cred  = new HBox();
        HBox hboxResetSubmit= new HBox();

        hboxTerm1Btns.setSpacing(20);
        hboxTerm2Btns.setSpacing(20);
        hboxTerm1Cred.setSpacing(20);
        hboxTerm2Cred.setSpacing(20);
        hboxResetSubmit.setSpacing(20);

        vboxTerm1Unsel.getChildren().addAll(lblTerm1UnSel, Term1UnSelect);
        vboxTerm2Unsel.getChildren().addAll(lblTerm2UnSel, Term2UnSelect);
        vboxTerm1Sel.getChildren().addAll(lblTerm1Sel, Term1Select);
        vboxTerm2Sel.getChildren().addAll(lblTerm2Sel, Term2Select);
        vboxYear.getChildren().addAll(lblYearSel, YearSelect);
        hboxTerm1Btns.getChildren().addAll(lblTerm1Btns, Term1AddBtn, Term1RemoveBtn);
        hboxTerm2Btns.getChildren().addAll(lblTerm2Btns, Term2AddBtn, Term2RemoveBtn);
        hboxTerm1Cred.getChildren().addAll(lblTerm1Cred, txtTerm1Cred);
        hboxTerm2Cred.getChildren().addAll(lblTerm2Cred, txtTerm1Cred);
        hboxResetSubmit.getChildren().addAll(ResetBtn, SubmitBtn);

        hboxTerm1Btns.setAlignment(Pos.CENTER);
        hboxTerm2Btns.setAlignment(Pos.CENTER);
        hboxTerm1Cred.setAlignment(Pos.CENTER);
        hboxTerm2Cred.setAlignment(Pos.CENTER);
        hboxResetSubmit.setAlignment(Pos.CENTER);

        VBox.setVgrow(Term1UnSelect, Priority.ALWAYS);
        VBox.setVgrow(Term2UnSelect, Priority.ALWAYS);
        VBox.setVgrow(Term1Select, Priority.ALWAYS);
        VBox.setVgrow(Term2Select, Priority.ALWAYS);
        VBox.setVgrow(YearSelect, Priority.ALWAYS);

        VBox.setVgrow(vboxTerm1Unsel, Priority.ALWAYS);
        VBox.setVgrow(vboxTerm2Unsel, Priority.ALWAYS);
        VBox.setVgrow(vboxYear, Priority.ALWAYS);
        VBox.setVgrow(vboxTerm1Sel, Priority.ALWAYS);
        VBox.setVgrow(vboxTerm2Sel, Priority.ALWAYS);

        VBox leftVBox = new VBox(vboxTerm1Unsel, hboxTerm1Btns, vboxTerm2Unsel, hboxTerm2Btns, hboxTerm1Cred);
        leftVBox.setSpacing(5);
        HBox.setHgrow(leftVBox, Priority.ALWAYS);

        VBox rightVBox = new VBox(vboxYear, vboxTerm1Sel, vboxTerm2Sel, hboxTerm2Cred);
        rightVBox.setSpacing(5);
        HBox.setHgrow(rightVBox, Priority.ALWAYS);

        rootHBox.getChildren().addAll(leftVBox, rightVBox);
        rootHBox.setSpacing(5);
        rootHBox.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        BorderPane.setAlignment(rootHBox, Pos.CENTER);
        this.setCenter(new StackPane(rootHBox));
        this.setBottom(hboxResetSubmit);

    }
}