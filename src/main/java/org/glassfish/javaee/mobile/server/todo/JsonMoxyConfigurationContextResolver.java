package org.glassfish.javaee.mobile.server.todo;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;

@Provider
public class JsonMoxyConfigurationContextResolver
        implements ContextResolver<MoxyJsonConfig> {

    @Override
    public MoxyJsonConfig getContext(Class<?> objectType) {
        MoxyJsonConfig configuration = new MoxyJsonConfig();

        Map<String, String> namespacePrefixMapper = new HashMap<>(1);
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        configuration.setNamespacePrefixMapper(namespacePrefixMapper);
        configuration.setNamespaceSeparator(':');

        return configuration;
    }
}