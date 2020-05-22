@Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof IdentifiableEntity)) return false;

      IdentifiableEntity entity = (IdentifiableEntity) o;
      //change
      if (!super.equals(o)) return false;

      if (id != null) {
         if (!id.equals(entity.id)) return false;
      } else {
         if (entity.id != null) return false;
      }

      return true;
   }

   @Override
   public int hashCode() {
      //change
      if (super.hashCode() != 0) return super.hashCode();
      return id != null ? id.hashCode() : 0;
   }