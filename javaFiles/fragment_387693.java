public static String get() {
        FenetreAjoutClass dialog = new FenetreAjoutClass(null, false);
        while (dialog.isVisible()) {
            System.out.println("is Visible");
        }
        System.out.println("is not Visible");
        return infos;
}