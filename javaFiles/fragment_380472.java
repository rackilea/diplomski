import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

static Class<? extends DefinitionBasedMigrator> createClass( String fullName )
        throws NotFoundException, CannotCompileException
{
    ClassPool pool = ClassPool.getDefault();

    // Create the class.
    CtClass subClass = pool.makeClass( fullName );
    final CtClass superClass = pool.get( DefinitionBasedMigrator.class.getName() );
    subClass.setSuperclass( superClass );
    subClass.setModifiers( Modifier.PUBLIC );

    // Add a constructor which will call super( ... );
    CtClass[] params = new CtClass[]{
        pool.get( MigratorDefinition.class.getName() ),
        pool.get( GlobalConfiguration.class.getName()) 
    };
    final CtConstructor ctor = CtNewConstructor.make( params, null, CtNewConstructor.PASS_PARAMS, null, null, subClass );
    subClass.addConstructor( ctor );

    return subClass.toClass();
}