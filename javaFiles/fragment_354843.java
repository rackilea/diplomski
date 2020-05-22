StandardProperty[] properties = event.getPersister().getEntityMetamodel().getProperties();
Object[] state = event.getState();

for (int i = 0; i < properties.length; i++) {
    if (properties[i].getName().equals("updated")) {
        state[i] = timestamp;
        break;
    }
}