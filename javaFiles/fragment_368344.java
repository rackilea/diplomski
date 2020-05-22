@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    IView view;

    @Mock
    IModel model;

    @Test
    public void when_model_changes_presenter_should_update_view() {
        ArgumentCaptor<Action> event = ArgumentCaptor.forClass(Action.class);

        when(model.getText()).thenReturn("test-string");
        new Presenter(model, view);
        verify(model).addModelChangeListener(event.capture());
        event.getValue().actionPerformed(null);
        verify(view).setText("test-string");
    }
}