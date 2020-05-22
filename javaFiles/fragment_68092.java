@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public abstract @interface JsonParam {

    public abstract String value();

}

@Provider
public class JsonParamProvider implements InjectableProvider<JsonParam, Type> {

    private Gson gson;

    public JsonParamProvider(@Context ServletConfig sc) throws Exception {
        super();
        this.gson = GsonFactory.newGson(sc);
    }

    @Override
    public Injectable<Object> getInjectable(ComponentContext cc, JsonParam a, Type type) {
        if (a.value() != null) {
            String signature = cc.getAccesibleObject().toString();
            return new JsonParamInjectable(signature, a, type, gson);
        }
        return null;
    }

    @Override
    public ComponentScope getScope() {
        return ComponentScope.Singleton;
    }

}

@Provider
public class JsonParamDispatchProvider extends AbstractResourceMethodDispatchProvider {

    @Override
    protected InjectableValuesProvider getInjectableValuesProvider(AbstractResourceMethod abstractResourceMethod) {
        return new JsonParamInjectableValuesProvider(processParameters(abstractResourceMethod));
    }

    //copied from EntityParamDispatchProvider source code
    private List<Injectable> processParameters(AbstractResourceMethod method) {

        if ((null == method.getParameters()) || (0 == method.getParameters().size())) {
            return Collections.emptyList();
        }

        boolean hasEntity = false;
        final List<Injectable> is = new ArrayList<Injectable>(method.getParameters().size());
        for (int i = 0; i < method.getParameters().size(); i++) {
            final Parameter parameter = method.getParameters().get(i);

            if (Parameter.Source.ENTITY == parameter.getSource()) {
                hasEntity = true;
                is.add(processEntityParameter(
                        parameter,
                        method.getMethod().getParameterAnnotations()[i]));
            } else {
                is.add(getInjectableProviderContext().
                        getInjectable(method.getMethod(), parameter, ComponentScope.PerRequest));
            }
        }

        if (hasEntity)
            return is;

        // Try to find entity if there is one unresolved parameter and
        // the annotations are unknown
        if (Collections.frequency(is, null) == 1) {
            final int i = is.lastIndexOf(null);
            final Parameter parameter = method.getParameters().get(i);
            if (Parameter.Source.UNKNOWN == parameter.getSource()) {
                if (!parameter.isQualified()) {
                    final Injectable ij = processEntityParameter(
                        parameter,
                        method.getMethod().getParameterAnnotations()[i]);
                    is.set(i, ij);
                }
            }
        }

        return is;
    }

    //copied from EntityParamDispatchProvider source code
    static final class EntityInjectable extends AbstractHttpContextInjectable<Object> {
        final Class<?> c;
        final Type t;
        final Annotation[] as;

        EntityInjectable(Class c, Type t, Annotation[] as) {
            this.c = c;
            this.t = t;
            this.as = as;
        }

        @Override
        public Object getValue(HttpContext context) {
            return context.getRequest().getEntity(c, t, as);
        }
    }

    //copied from EntityParamDispatchProvider source code
    private Injectable processEntityParameter(
            Parameter parameter,
            Annotation[] annotations) {
        return new EntityInjectable(parameter.getParameterClass(),
                parameter.getParameterType(), annotations);
    }

}

@SuppressWarnings("rawtypes")
public class JsonParamInjectableValuesProvider extends InjectableValuesProvider {

    public static final String JSON_ELEMENT_CONTEXT_PROPERTY_KEY = "JsonParamInjectableValuesProvider.jsonElementContextPropertyKey";

    public JsonParamInjectableValuesProvider(List<Injectable> is) {
        super(is);
    }

    /**
     * Get the injectable values.
     *
     * @param context the http contest.
     * @return the injectable values. Each element in the object array
     *         is a value obtained from the injectable at the list index
     *         that is the element index.
     */
    @Override
    public Object[] getInjectableValues(HttpContext context) {
        List<AbstractHttpContextInjectable> is = getInjectables();
        final Object[] params = new Object[is.size()];
        try {
            //parse json element and add it to context
            context.getProperties().put(JSON_ELEMENT_CONTEXT_PROPERTY_KEY, parseJsonElement(context));
            //map jsonElement with injectable
            int index = 0;
            for (AbstractHttpContextInjectable i : is) {
                params[index++] = i.getValue(context);
            }
            return params;
        } catch (WebApplicationException e) {
            throw e;
        } catch (ContainerException e) {
            throw e;
        } catch (RuntimeException e) {
            throw new ContainerException("Exception obtaining parameters", e);
        } finally {
            context.getProperties().remove(JSON_ELEMENT_CONTEXT_PROPERTY_KEY);
        }
    }

    private static JsonElement parseJsonElement(HttpContext context) {
        String entity = context.getRequest().getEntity(String.class);
        if (StringUtils.isBlank(entity)) {
            throw new ContainerException("entity is blank for request " + context.getRequest());
        }
        JsonParser parser = new JsonParser();
        return parser.parse(entity);
    }
}

public class JsonParamInjectable extends AbstractHttpContextInjectable<Object> {

    private final JsonParam param;
    private final Type type;
    private final String signature;
    private final Gson gson;

    public JsonParamInjectable(String signature, JsonParam param, Type type, Gson gson) {
        this.signature = signature;
        this.param = param;
        this.type = type;
        this.gson = gson;
    }

    @Override
    public Object getValue(HttpContext context) {
        try {
            JsonElement jsonElement = (JsonElement) context.getProperties().get(JsonParamInjectableValuesProvider.JSON_ELEMENT_CONTEXT_PROPERTY_KEY);
            if (jsonElement == null) {
                throw new ContainerException("invalid json element in context. " + context.getRequest());
            }
            if (jsonElement == null || jsonElement.isJsonNull()) {
                return null;
            }
            final JsonElement valueJsonElement = ((JsonObject)jsonElement).get(this.param.value());
            if (valueJsonElement == null || valueJsonElement.isJsonNull()) {
                return null;
            }
            if (this.type.equals(java.lang.Integer.class)) {
                Number number = valueJsonElement.getAsNumber();
                return number.intValue();
            }
            if (this.type.equals(java.lang.String.class)) {
                return valueJsonElement.getAsString();
            }
            Class<?> c = ((Class<?>) this.type);
            if (int.class.equals(c)) {
                return valueJsonElement.getAsInt();
            }
            if (long.class.equals(c)) {
                return valueJsonElement.getAsLong();
            }
            if (boolean.class.equals(c)) {
                return valueJsonElement.getAsBoolean();
            }
            //other parsing code...

            //try with gson
            return this.gson.fromJson(valueJsonElement, this.type);

        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "JsonParamInjectable " + this.hashCode() + " [param=" + this.param + ", type=" + this.type + ", signature=" + this.signature + "]";  }

}