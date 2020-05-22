int defaultLang = -1;
for(int i = 0; i < items.length; i++) {
    if(items[i].toString().equalsIgnoreCase(Locale.getDefault().getDisplayLanguage())) {
        defaultLang = i;
        break;
    }
}