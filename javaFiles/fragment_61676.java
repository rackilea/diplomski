public class CustomWeaponDetailListCell<T extends Weapon> extends ListCell<T> {

    private final StringBuilder sb = new StringBuilder();

    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
            setText(null);
        } else {
            sb.append(item.getName()).append("    Detail:")
                    .append((String) CsgoRr.objectToJsonString(item.getRecoilPattern()));

            setText(sb.toString());

            // clear StringBuilder content
            sb.delete(0, sb.length());
        }
    }
}