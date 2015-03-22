package org.nraov.vertx.jersey.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.json.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nageswara.v on 3/22/2015.
 */
public class ConfigManager {
    public static void loadConfig(JsonObject config, String configFile) {
        Path configPath = Paths.get(configFile);
        Map<String, Object> props = new HashMap<>();
        System.out.println(configPath.toAbsolutePath().toString());
        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(configPath);
            ObjectMapper objectMapper = new ObjectMapper();
            props = objectMapper.readValue(jsonData, HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (config != null) {
            JsonObject serverConfig = new JsonObject((Map) props.get(ServiceConstants.CONFIG_JERSEY));
            config.put(ServiceConstants.SERVER_CONFIG_HOST_KEY, 
                    serverConfig.getValue(ServiceConstants.SERVER_CONFIG_HOST_KEY));
            config.put(ServiceConstants.SERVER_CONFIG_PORT_KEY, 
                    serverConfig.getValue(ServiceConstants.SERVER_CONFIG_PORT_KEY));
            config.put(ServiceConstants.SERVER_CONFIG_BASEPATH_KEY, 
                    serverConfig.getValue(ServiceConstants.SERVER_CONFIG_BASEPATH_KEY));
        }
    }
}
