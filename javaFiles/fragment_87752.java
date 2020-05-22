@Listen("onClick = button#load")
public void load() {
    Messagebox.show("Are you sure to execute Load?", "Execute?", Messagebox.YES | Messagebox.NO, 
        Messagebox.QUESTION, new EventListener<Event>() {
            @Override
            public void onEvent(final Event evt) throws InterruptedException {
                if (Messagebox.ON_YES.equals(evt.getName())) {
                    // Code if yes clicked
                } else {
                    // Code if no clicked
                }
            }
        }
    );
}