/*
 * Copyright 2012 ClamShell-Cli.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.clamshellcli.impl.commands;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * This class implements the Help command.
 * <ul>
 * <li> Usage: help - displays description for all installed commands.
 * <li> Usage: help [command_name] displays command usage.
 * </ul>
 * @author vladimir.vivien
 */
public class HelpCmd implements Command{
// There is no space between class and interface definition
    private static final String NAMESPACE = "syscmd";
    private static final String CMD_NAME = "help";
    private HelpCmdDescriptor descriptor = new HelpCmdDescriptor();
    
    private class HelpCmdDescriptor implements Command.Descriptor {
    // There is no space between class and method definition
        @Override public String getNamespace() {return NAMESPACE;}
        
        @Override
        public String getName() {
            return CMD_NAME;
        }

        @Override
        public String getDescription() {
            return "Displays help information for available commands.";
        }

        @Override
        public String getUsage() {
            return "Type 'help' or 'help [command_name]' ";
        }

        @Override
        public Map<String, String> getArguments() {
            return Collections.emptyMap();
            
        }
    }
    
    @Override
    public Command.Descriptor getDescriptor() {
        return descriptor;
    }

    /**
     * Executes the Help command.
     * The help command expects format 'help [command_name]'.
     * If the optional command_name parameter is present, this class will 
     * display info about about the command.  If command_name is not present
     * the Help command displays a list of help for all installed command.
     * @param ctx
     * @return 
     */
    @Override
    public Object execute(Context ctx) {
     // There is no space between method definition and variable declaration
        String[] args = (String[]) ctx.getValue(Context.KEY_COMMAND_LINE_ARGS);

        // if arg passed, display help for command matching arg.
        if(args != null && args.length > 0){
            printCommandHelp(ctx, args[0].trim());
        }else{
            printAllHelp(ctx);
        }
        ctx.getIoConsole().printf("%n%n");
        return null;
    }

    @Override
    public void plug(Context plug) {
        // no plugin action needed
    }
    
    @Override
    public void unplug(Context plug){
        // nothing to do
    }
    
    private void printCommandHelp(Context ctx, String cmdName){
    // There is no space between method definition and variable declaration
        Map<String, Command> commands = ctx.mapCommands(ctx.getCommands());
        if(commands != null){
            Command cmd = commands.get(cmdName.trim());
            if(cmd != null){
                printCommandHelp(ctx, cmd);
            }else{
                ctx.getIoConsole().printf(
                        "%nUnable to find command [%s].", cmdName
                );
            }
        }
    }
    
    private void printCommandHelp(Context ctx, Command cmd){
    // There is no space between method definition and variable declaration
        if(cmd != null && cmd.getDescriptor() != null){
            IOConsole io = ctx.getIoConsole();
            io.printf("%n@|bold,red Command:|@ %s - %s%n", 
                cmd.getDescriptor().getName(), 
                cmd.getDescriptor().getDescription()
            );
            io.printf("Usage: %s", cmd.getDescriptor().getUsage());
            printCommandParamsDetail(ctx, cmd);
        }else{
            ctx.getIoConsole().println("Unable to display help for command.");
        }
    }
    
    private void printCommandParamsDetail(Context ctx, Command cmd){
        // There is no space between method definition and variable declaration
        Command.Descriptor desc = cmd.getDescriptor();
        if(desc == null || desc.getArguments() == null) return;
        IOConsole c = ctx.getIoConsole();
        c.printf("%nOptions:");
        c.printf("%n--------");
        for(Map.Entry<String,String> entry : desc.getArguments().entrySet()){
            c.printf(
                "%n%1$25s\t%2$s", 
                entry.getKey(), 
                entry.getValue()
            );            
        }
    }
    
    private void printAllHelp(Context ctx){

        IOConsole c = ctx.getIoConsole();
        c.printf("%nAvailable Commands");
        c.printf("%n------------------");
        List<Command> commands = ctx.getCommands();
        for(Command cmd : commands){
            c.printf(
                "%n%1$10s %2$5s %3$s", 
                cmd.getDescriptor().getName(), 
                " ", 
                cmd.getDescriptor().getDescription()
            );
        }
    }
    
}
// Class name start with the capital letters and first letter of each internal word capitalized..
//Block command used before each of the method.
//Method name starts with the simple letter and first letter of each internal word capitalized.
//First non comment line in this java class is package and import.
//Constants define by all Uppercase letters and they are separated by the _(underscore).
//Conditional loop written in the proper way.
//for loop written in the proper way.
//Reference variable call by the class instead of class object.
//Long length separated by the comma.