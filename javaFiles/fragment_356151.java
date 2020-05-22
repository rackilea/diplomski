public class YamlPropertiesPersister implements PropertiesPersister {
@Override
public void load(Properties props, InputStream is) throws IOException {
    load(props, new InputStreamReader(is));
}

/**
 * We want to traverse map representing Yaml object and each time we find String=String pair we want to
 * save it as Property. As we are going deeper into map we generate compound key as path-like String
 * 
 * @param props
 * @param reader
 * @throws IOException
 * @see org.springframework.util.PropertiesPersister#load(java.util.Properties, java.io.Reader)
 */
@Override
public void load(Properties props, Reader reader) throws IOException {
    Yaml yaml = CollectorUtils.instanceOfYaml();
    Map<String, Object> map = (Map<String, Object>) yaml.load(reader);
    // now we can populate supplied props
    assignProperties(props, map, null);
}

/**
 * @param props
 * @param map
 */
public void assignProperties(Properties props, Map<String, Object> map, String path) {
    for (Entry<String, Object> entry : map.entrySet()) {
        String key = entry.getKey();
        if (StringUtils.isNotEmpty(path))
            key = path + "." + key;
        Object val = entry.getValue();
        if (val instanceof String) {
            // see if we need to create a compound key
            props.put(key, val);
        } else if (val instanceof Map) {
            assignProperties(props, (Map<String, Object>) val, key);
        }
    }
}

@Override
public void store(Properties props, OutputStream os, String header) throws IOException {
    throw new NotImplementedException("Current implementation is a read-only");
}

@Override
public void store(Properties props, Writer writer, String header) throws IOException {
    throw new NotImplementedException("Current implementation is a read-only");
}

@Override
public void loadFromXml(Properties props, InputStream is) throws IOException {
    throw new NotImplementedException("Use DefaultPropertiesPersister if you want to read/write XML");
}

@Override
public void storeToXml(Properties props, OutputStream os, String header) throws IOException {
    throw new NotImplementedException("Use DefaultPropertiesPersister if you want to load/store to XML");
}

@Override
public void storeToXml(Properties props, OutputStream os, String header, String encoding) throws IOException {
    throw new NotImplementedException("Use DefaultPropertiesPersister if you want to read/write XML");
}
}