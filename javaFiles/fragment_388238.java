public <T extends Component> T getComponent(Class<T> type)
{
    for (Component c : components) {
         if (type.isInstance(c)) {
             return (T) c;
         }
    }
    return null;
}