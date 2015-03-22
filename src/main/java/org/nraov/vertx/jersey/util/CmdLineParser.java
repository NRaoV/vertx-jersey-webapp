package org.nraov.vertx.jersey.util;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Enumeration;
import java.util.Properties;

/**
 * Command line argument parser. Useful to compose 
 * - Help on command line
 * - Parser for commandline arguments  
 *
 * Created by nageswara.v on 7/28/2014.
 */
public class CmdLineParser {

    private static Logger log = LoggerFactory.getLogger("CmdLineParser");

    private static Options cmdLineOptions = new Options();

    private static CmdLineParser instance = new CmdLineParser();

    private CmdLineParser() {
        initCmdLineOptions();
    }

    public static CmdLineParser getInstance() {
        return instance;
    }
    
    private void initCmdLineOptions() {
        Option help = new Option("h", "Prints help message");
        //Option verbose = new Option("v", "Verbose output");

        Option props = OptionBuilder.withArgName("property=value")
                .hasArgs()
                .withValueSeparator()
                .withDescription("Usage : -D config=<config file name>")
                .create("D");
        cmdLineOptions.addOption(help);
        cmdLineOptions.addOption(props);
    }

    public CommandLine getCommadLine(String args[]) throws ParseException {
        CommandLineParser parser = new BasicParser();
        CommandLine line = null;
        // parse the command line arguments
        line = parser.parse(cmdLineOptions, args);
        return line;
    }

    /**
     * @param args -D config=<config json file name>
     * @return
     */
    public Properties getCmdLineArgs(String[] args) {
        CommandLineParser parser = new BasicParser();
        Properties cmdLineArgs = new Properties();
            // parse the command line arguments
        CommandLine line = null;
        try {
            line = parser.parse(cmdLineOptions, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cmdLineArgs = line.getOptionProperties("D");
        return cmdLineArgs;
    }

    public void showCommandLineUsage() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("./<CommadLine Script>.sh", cmdLineOptions);
    }

    public static void main(String[] args) {
        CmdLineParser parser = new CmdLineParser();
            Properties options = parser.getCmdLineArgs(args);
            Enumeration names = options.propertyNames();
            while (names.hasMoreElements()) {
                String name = (String)names.nextElement();
                System.out.println("Name : " + name + ", Value : " + options.getProperty(name));
            }

        parser.showCommandLineUsage();
    }
}
