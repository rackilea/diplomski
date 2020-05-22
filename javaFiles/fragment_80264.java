private final Map<String,JButton> buttonMap = new HashMap<String,JButton>();
private List<JButton> buttons = Arrays.asList(utilaj1, ..., utilaj20);

public MainScreen() {
    for(i=1;i<=20;i++){
        buttonMap.put("utilaj"+i, buttons.get(i));
    }
}