import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.type.*;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.*;

@SupportedAnnotationTypes("com.gotofinal.enuminterface.EnumInterface")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class EnumInterfaceProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Messager messager = processingEnv.getMessager();
        Types typeUtils = processingEnv.getTypeUtils();

        // first we scan for all interfaces marked with this annotation
        List<TypeElement> enumOnlyInterfaces = new ArrayList<>();
        for (Element rootElement : roundEnv.getRootElements()) { // getRootElements should return all types being compiled
            if (! (rootElement instanceof TypeElement)) {
                continue;
            }
            TypeMirror typeMirror = rootElement.asType();
            // we check if this class have our annotation, we could also here check if this is an interface (by checking if it does not extend Object directly) and throw error otherwise
            if (rootElement.getAnnotation(EnumInterface.class) != null) {
                enumOnlyInterfaces.add((TypeElement) rootElement);
            }
        }

        // and now we scan for any non enum types that implement this interface
        for (Element rootElement : roundEnv.getRootElements()) {
            if (! (rootElement instanceof TypeElement)) {
                continue;
            }
            TypeElement type = findImplementedInterface(rootElement.asType(), enumOnlyInterfaces, typeUtils);
            if (type == null) {
                continue;
            }
            if (! (rootElement.asType() instanceof DeclaredType)) {
                continue;
            }

            // it's fine if it is an enum
            if (this.isEnum(rootElement.asType(), typeUtils)) {
                continue;
            }

            // and we print error to compiler
            messager.printMessage(Diagnostic.Kind.ERROR, "Interface " + type.getQualifiedName()
                                                                 + " can't be used on non enum class: " + ((TypeElement) rootElement).getQualifiedName());
        }
        return false;
    }

    public TypeElement findImplementedInterface(TypeMirror type, List<TypeElement> interfaces, Types types) {
        for (TypeElement anInterface : interfaces) {
            // types.isSubtype(typeA, typeA) would return true, so we need to add this equals check
            if (!anInterface.asType().equals(type) && types.isSubtype(type, anInterface.asType())) {
                return anInterface;
            }
        }
        return null;
    }

    // maybe there is better way to do this... but I just scan recursively for a subtype with java.lang.Enum name, so it's not perfect but should be enough.
    public boolean isEnum(TypeMirror type, Types types) {
        for (TypeMirror directSupertype : types.directSupertypes(type)) {
            TypeElement element = (TypeElement) ((DeclaredType) directSupertype).asElement();
            if (element.getQualifiedName().contentEquals("java.lang.Enum")) {
                return true;
            }
            if (isEnum(directSupertype, types)) {
                return true;
            }
        }
        return false;
    }
}