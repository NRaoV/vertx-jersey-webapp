package org.nraov.vertx.jersey.util;

import io.vertx.core.json.JsonObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Abstracted out functionality related to loading configuration from the given file
 *
 * Created by nageswara.v on 3/22/2015.
 */
public class ConfigManager {
    public static JsonObject loadConfig(String configFile) {
        Path configPath = Paths.get(configFile);
        Map<String, Object> props = new HashMap<>();
        System.out.println(configPath.toAbsolutePath().toString());
        byte[] jsonData = new byte[0];
        try {
            jsonData = Files.readAllBytes(configPath);
            return new JsonObject(new String(jsonData));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonObject();
    }
}
