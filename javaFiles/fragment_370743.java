class EnumRadioButtons<T> {

    public EnumRadioButtons(Collection<T> options, Function<T,String> f ) {
        for (T option : options) {
            this.setTitleOfEachOption(option, f.apply(option));
        }
    }

    public void setTitleOfEachOption(T option, String title) {
          System.out.println("DEBUG - Setting title of option: " + option  + " to have title of: " + title );
    }
}