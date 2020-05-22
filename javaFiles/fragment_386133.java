Optional<Preset> optional = Arrays.stream(presets)
                                   .filter(x -> "MyString".equals(x.getName()))
                                   .findFirst();

if(optional.isPresent()) {//Check whether optional has element you are looking for
    Preset p = optional.get();//get it from optional
}