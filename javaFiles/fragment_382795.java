@XmlTransient
   char gender = 'M';

   @XmlElement(name="gender")
   public void setGenderAsString(String gender) {
      this.gender = gender.charAt(0);
   }

   public String getGenderAsString() {
      return String.valueOf(gender);
   }