#!/bin/bash
#-------------------------------------------------------------
# running fpservice
# author: Nageswara Rao
# since: Feb 17 , 2015.
#-------------------------------------------------------------

echo "setting environment for FPService"

FPSERVICE_HOME=`pwd`
export FPSERVICE_HOME
echo "FPService home is set to" $FPSERVICE_HOME
cd $FPSERVICE_HOME

java -jar -Xmx1024m -Xms512m ${project.artifactId}-${project.version}.jar -D config=resources/config.json
