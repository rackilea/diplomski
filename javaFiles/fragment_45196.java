public class Chef {
  private Provider<Pasta> mPastaProvider;
  private Sauce mSauce;

  @Inject
  public void registerIngredients(     // can be named anything
      Provider<Pasta> pastaProvider,
      Sauce sauce) {                   // T and Provider<T> both work, of course
    mPastaProvider = pastaProvider;
    mSauce = sauce;
  }

  /* Non-@Inject */ public Dinner cookDinner() {
    mPan.add(mPastaProvider.get());
    mPan.add(mSauce);
    return mPan.cookDinner();
  }

  /* Non-@Inject */ public Dinner fryDinner() {
    mPan.add(mPastaProvider.get());
    mPan.add(mSauce);
    return mPan.fryDinner();
  }
}