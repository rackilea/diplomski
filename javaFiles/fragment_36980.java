276 public String getParameterName() {
277     if (this.parameterNameDiscoverer != null) {
278         String[] parameterNames = (this.method != null ?
279                 this.parameterNameDiscoverer.getParameterNames(this.method) :
280                 this.parameterNameDiscoverer.getParameterNames(this.constructor));
281         if (parameterNames != null) {
282             this.parameterName = parameterNames[this.parameterIndex];
283         }
284         this.parameterNameDiscoverer = null;
285     }
286     return this.parameterName;
287 }