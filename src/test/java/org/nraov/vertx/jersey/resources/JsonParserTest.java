package org.nraov.vertx.jersey.resources;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.vertx.core.json.JsonObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nageswara.v on 2/17/2015.
 */
public class JsonParserTest {
    //http://www.journaldev.com/2324/jackson-json-processing-api-in-java-example-tutorial
    public static void main(String[] args) {
        JsonFactory jfactory = new JsonFactory();
        try {
            Path configPath = Paths.get("src/main/resources/config.json");
            //byte[] mapData = Files.readAllBytes(Paths.get("data.txt"));
            System.out.println(configPath.toAbsolutePath().toString());
            byte[] jsonData = Files.readAllBytes(configPath);

            JsonObject obj = new JsonObject(new String(jsonData));
            System.out.println("Json Object: " + obj);
            
            Map<String, Object> myMap = new HashMap<String, Object>();
            ObjectMapper objectMapper = new ObjectMapper();
            myMap = objectMapper.readValue(jsonData, HashMap.class);

            System.out.println("Resources : " + myMap);
            
/*            for (Map.Entry<String, Object> entry: myMap.entrySet()) {
                System.out.println("Name : " + entry.getKey() +", Value : " + entry.getValue());
                System.out.println("Value class : " + entry.getValue().getClass().getName());
            }
            System.out.println("Map is: "+myMap);*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
