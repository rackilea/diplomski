@Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof BasicNodeEntity)) return false;

      BasicNodeEntity that = (BasicNodeEntity) o;

      if (nodeId != null) {
         if (!nodeId.equals(that.nodeId)) return false;
      } else {
         if (that.nodeId != null) return false;
      }

      return true;
   }

   @Override
   public int hashCode() {
      return nodeId != null ? nodeId.hashCode() : 0;
   }