Object[] keys = keySet.toArray(new Object[keySet.size()]);

for (Object key : keys) {

    if (key != null && key.toString().toLowerCase().contains("font")) {

        Object oValue = UIManager.getDefaults().get(key);

        if (oValue != null) {

            String value = oValue == null ? null : UIManager.getDefaults().get(key).toString();
            UIManager.put(key, font);

        }

    }

}