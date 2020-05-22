public class ListStuff extends ListActivity {

    private ToastFunctionClass toaster = new ToastFunctionClass(this); //pass yourself so that toaster has a Context in which to do UI stuff.

    onSomethingHappened() {
        toaster.showToast("Something happened");
    }

}