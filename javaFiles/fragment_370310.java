public class JourneyStoreViewModelFactory implements ViewModelProvider.Factory {

    private final JourneyRepository journeyRepository;

    JourneyStoreViewModelFactory(JourneyRepository journeyRepository){
        this.journeyRepository = journeyRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == AddJourneyViewModel.class){
            // Instantiates the ViewModels with their repository reference.
            return (T) new AddJourneyViewModelImpl(journeyRepository);
        }
        throw new IllegalArgumentException(String.format("Requested class %s did not match expected class %s.", modelClass, AddJourneyViewModel.class));
    }
}