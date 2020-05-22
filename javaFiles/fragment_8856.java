private MyText myText;
private List<SelectItem> myTextItems;

@PostConstruct
public void init() {
    myTextItems = new ArrayList<SelectItem>();

    for (MyText myText : myTextService.list()) {
        myTextItems.add(new SelectItem(myText, myText.getText()));
    }
}

// ...