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
package org.clamshellcli.core;

/**
 * A simple wrapper of the RuntimeExceptino type.
 * @author vladimir.vivien
 */
public class ShellException extends RuntimeException{

    public ShellException(){
        super();
    }
    public ShellException(String msg){
        super(msg);
    }
    public ShellException(Throwable ex){
        super(ex);
    }
    public ShellException(String msg, Throwable ex){
        super(msg, ex);
    }
}
// They written the class name properly starts with the capital letter and first letter of each internal word capitalized
//The choice of a variable name indicate to the casual observer the intent of its use and avoid single letter as a variable
// Used block comments start of class.
//First non comment line in this java class is package.