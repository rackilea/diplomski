private Drawable getIconForAccount(Account account, AccountManager manager) {
        AuthenticatorDescription[] descriptions =  manager.getAuthenticatorTypes();
        PackageManager pm = getContext().getPackageManager();
        for (AuthenticatorDescription description: descriptions) {
            if (description.type.equals(account.type)) {
                return pm.getDrawable(description.packageName, description.iconId, null); 
            }
        }
        return null;
    }