project.configurations.all { config ->
  config.resolutionStrategy.dependencySubstitution({ 
      it.substitute(
         it.module('javax.validation:validation-api')
      ).with(
         it.module('javax.validation:validation-api:1.0.0.GA')
      )
  } as Action<DependencySubstitutions>)    
}