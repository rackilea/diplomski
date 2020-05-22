@Listen("onClick = #addRejectDocumentBtn")
public void openWaiting() {
    Clients.showBusy(saleRejectMainPageWin,"please wait...");

    saleRejectMainPageWin.addEventListener(Events.ON_CLIENT_INFO, new EventListener<Event>() {
        @Override
        public void onEvent(Event event) throws Exception {
            LongOperationExample();      <- here is my long operation                

            Clients.clearBusy(saleRejectMainPageWin);
        }
    });


    "Here you can call the event" 
    Events.echoEvent("onClientInfo", saleRejectMainPageWin, null);

}