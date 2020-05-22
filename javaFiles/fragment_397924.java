public enum EnumOption {

   YES("Y"), NO("N"), DEFAULT("");

   private final String value;

   private final static Map<String, EnumOption> options;

   static {
          options = new HashMap<String, EnumOption>();
          for (EnumOption opt : EnumOption.values()) {
                 options.put(opt.value, opt);
          }
   }

   private EnumOption(String value) {
          this.value = value;
   }

   public static EnumOption DBToOption(String val) {
          return options.get(val) != null ? options.get(val) : DEFAULT;
   }
}