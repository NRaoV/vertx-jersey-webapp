package org.nraov.vertx.jersey;

import com.englishtown.vertx.jersey.JerseyVerticle;
import io.vertx.core.Context;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import org.nraov.vertx.jersey.util.CmdLineParser;
import org.nraov.vertx.jersey.util.ConfigManager;
import org.nraov.vertx.jersey.util.ServiceConstants;

import java.util.Properties;

public class Runner {

	private static final Vertx vertx = Vertx.vertx();

	public static void main(String[] args) {

        Context context = vertx.getOrCreateContext();
        JsonObject config = context.config();

        Properties props = CmdLineParser.getInstance().getCmdLineArgs(args);
        ConfigManager.loadConfig(config, props.getProperty(ServiceConstants.CONFIG_SOURCE));

        //JsonObject config = new JsonObject();
        config.put(ServiceConstants.RESOURCE_KEY, new JsonArray().add(ServiceConstants.SERVER_CONFIG_RESOURCES_KEY));
        System.out.println(config.toString());

        DeploymentOptions options = new DeploymentOptions();
        // options.setIsolationGroup("A");
        options.setConfig(config);

        vertx.deployVerticle("java-hk2:" + JerseyVerticle.class.getCanonicalName(), options);
	}
}
