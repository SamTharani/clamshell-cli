/*
 * #%L
 * clamshell-api
 * %%
 * Copyright (C) 2011 ClamShell-Cli
 * %%
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
 * #L%
 */
package org.clamshellcli.api;

/**
 * The SplashScreen plugin lets you build a textual screen that is displayed
 * at the start of the shell.
 * 
 * @author Vladimir.Vivien
 */
public interface SplashScreen extends Plugin {
    /**
     * This method is called when the Shell is ready to display the SplashScreen.
     * @param ctx 
     */
    public void render(Context ctx);
}
//Interface name start with the capital letters.
//Block command used before each of the method.
// Method name starts with the simple letter and first letter of each internal word capitalized.
//First non comment line in this java class is package and import.
