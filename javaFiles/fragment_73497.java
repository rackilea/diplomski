if (route != null && route.length() > 0) {
    buffer.append('.').append(route);
} else {
    String jvmRoute = getJvmRoute();
    if (jvmRoute != null && jvmRoute.length() > 0) {
        buffer.append('.').append(jvmRoute);
    }
}