@Configuration
@ComponentScans({ 
    @ComponentScan(basePackages = "com.baeldung.annotations"), 
    @ComponentScan(basePackageClasses = VehicleFactoryConfig.class)
})
class VehicleFactoryConfig {}