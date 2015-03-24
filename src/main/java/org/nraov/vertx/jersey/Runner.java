package org.nraov.vertx.jersey;

import com.englishtown.vertx.jersey.JerseyVerticle;
import io.vertx.core.Context;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import org.nraov.vertx.jersey.util.CmdLineParser;
import org.nraov.vertx.jersey.util.ConfigManager;
import org.nraov.vertx.jersey.util.ServiceConstants;

import java.util.Properties;

/**
 * Runner class
 * - Loads configuration using value mentioned at command line -D config 
 * - Initializes http server using configuration properties
 * - Initializes REST services from resource folder
 */
public class Runner {

	private static final Vertx vertx = Vertx.vertx();

	public static void main(String[] args) {
        Context context = vertx.getOrCreateContext();
        JsonObject config = context.config();
        Properties props = CmdLineParser.getInstance().getCmdLineArgs(args);
        config.mergeIn(ConfigManager.loadConfig(props.getProperty(ServiceConstants.CONFIG_SOURCE)));
        JsonObject jerseyConfig = config.getJsonObject(ServiceConstants.CONFIG_JERSEY);
        DeploymentOptions options = new DeploymentOptions();
        // options.setIsolationGroup("A");
        options.setConfig(jerseyConfig);
        vertx.deployVerticle("java-hk2:" + JerseyVerticle.class.getCanonicalName(), options);
	}
}
