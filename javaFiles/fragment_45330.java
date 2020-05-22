@Context
private ResourceInfo info;

@Override
public void filter(ContainerRequestContext crc) throws IOException {
    Method method = info.getResourceMethod();
    CheckPermissions annotation = method.getAnnotation(CheckPermissions.class);
    if (annotation != null) {
        String[] permissions = annotation.value();
    }
}