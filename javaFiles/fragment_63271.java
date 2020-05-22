public class ViewModelTest {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    BehaviorSubject<List<Data>> observable;
    @Mock
    Subscription subscription;
    List<Data> data = Collections.emptyList();

    @Test
    public void Constructor_CalledWithObservable_subcribesSetDataMethod() {
        // prepare
        when(model.subscribe()).thenRetun(subscription);

        // act
        ViewModel viewModel = new ViewModel(observable);

        // assert
        verify(observable).subscribe(ViewModel::setData);
    }

    @Test
    public void destroy_unsubscribes() {
        // prepare
        when(model.subscribe()).thenRetun(subscription);    
        ViewModel viewModel = new ViewModel(observable);

        // act
        viewModel.destroy();    

        // assert
        verify(subscription).unsubscribe();
    }
}