class TextWatcher(presenter: MVPWatcherInterface) : ParentTextWatcher {

  private val presenterInterface: WeakReference<MVPWatcherInterface> = WeakReference(presenter)

  override fun onSomeTextEvent(){
    presenterInterface.get()?.onWatcherEventSomeTextEvent()
  }
}