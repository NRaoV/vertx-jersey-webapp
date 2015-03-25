# vertx-jersey-webapp

Example of creating JAX-RS jersey resources that will handle incoming http requests to vert.x.

# Getting Started

###Execute

#####vertex-jersey-webapp>mvn clean install

Command will build the module and prepare distribution zip  "vertx-jersey-webapp-0.1.zip" in target folder

###Folder structure after extracting the zip

- /resources/ - contains configurations in json format
- /run.sh - script to start the vertx instance
- /vertx-jersey-webapp-1.0-SNAPSHOT.jar - Archive that contains Runner to start JerseyVerticle verticle and JAX-RS jersey resources

###Start the service to get resources deployed in JerseyVerticle

Linux: Start "run.sh" from the root folder

Windows: Migrate run.sh to run.bat or just run the command "java -jar -Xmx1024m -Xms512m vertx-jersey-webapp-1.0-SNAPSHOT.jar -D config=resources/config.json"

With this vertx service will be up and running at "http://localhost:8080/" [based on the properties given in config.json]

# JAX-RS jersey Resources

Module comes with couple of test resources to get started from developer point of view. In this example, Test1Resource and Test2Resouces which are placed in "resources" package.

Test1Resource and Test2Resource can be tested with the urls "http://localhost:8080/test1/id" and "http:/localhost:8080/test2/id" respectively.

Developer can just resources in the "resource" package. New resources will be automatically deployed and available with respect to @Path parameter.
