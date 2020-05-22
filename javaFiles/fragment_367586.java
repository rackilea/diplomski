List<Consultation> consultations = provider.getItems();
    ArrayList<Consultation> showing;
    if (consultations instanceof ArrayList<?>) {
        showing = (ArrayList<Consultation>) consultations;
    } else {
        showing = new ArrayList<>(consultations);
    }