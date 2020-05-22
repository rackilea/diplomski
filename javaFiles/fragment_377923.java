final boolean More ...isInvalid() {
         if (status == null) {
             status = (this.path.indexOf('\u0000') < 0) ? PathStatus.CHECKED
                                                        : PathStatus.INVALID;
         }
         return status == PathStatus.INVALID;
     }