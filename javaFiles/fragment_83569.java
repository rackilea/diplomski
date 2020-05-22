private String label;
private Integer value;

@PostConstruct
public void init() {
    label = "Amateur";
    value = "Amateur".equals(label) ? 1 : 0;
}