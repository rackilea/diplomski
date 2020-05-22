import org.kie.api.*;
import org.kie.api.builder.*;
import org.kie.api.runtime.*;

KieServices ks = KieServices.Factory.get();
KieFileSystem kfs = ks.newKieFileSystem();
FileInputStream fis = new FileInputStream( CTES.RULES );
kfs.write( "src/main/resources/sale.drl",
            ks.getResources().newInputStreamResource( fis ) );
KieBuilder kieBuilder = ks.newKieBuilder( kfs ).buildAll();
Results results = kieBuilder.getResults();
if( results.hasMessages( Message.Level.ERROR ) ){
     System.out.println( results.getMessages() );
     throw new IllegalStateException( "### errors ###" );
}
KieContainer kieContainer =
     ks.newKieContainer( ks.getRepository().getDefaultReleaseId() );

KieBaseConfiguration config = ks.newKieBaseConfiguration();
config.setOption( EventProcessingOption.STREAM );
KieBase kieBase = kieContainer.newKieBase( config );
KieSession kieSession = kieBase.newKieSession();