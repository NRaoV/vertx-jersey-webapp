#!/bin/bash
#-------------------------------------------------------------
# running service
# author: Nageswara Rao
# since: Feb 17 , 2015.
#-------------------------------------------------------------

echo "setting environment for FPService"

SERVICE_HOME=`pwd`
export SERVICE_HOME
echo "SERVICE_HOME is set to" $SERVICE_HOME
cd $SERVICE_HOME

java -jar -Xmx1024m -Xms512m ${project.artifactId}-${project.version}.jar -D config=resources/config.json
