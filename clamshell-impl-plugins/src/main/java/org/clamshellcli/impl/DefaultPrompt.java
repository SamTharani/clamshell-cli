/*
 * Copyright 2013 ClamShell-Cli.
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
package org.clamshellcli.impl;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.Prompt;

/**
 * Default Prompt implementation.
 * Will be used if none is found on classpath.
 * @author Vladimir Vivien
 */
public class DefaultPrompt implements Prompt {

    private final String PROMPT = "cli> ";

    @Override
    public String getValue(Context ctx) {
        return PROMPT;
    }

    @Override
    public void plug(Context plug) {
    }

    @Override
    public void unplug(Context plug) {
    }
}
//Class name start with the capital letters and first letter of each internal word capitalized..
//Block command used before each of the method.
//Method name starts with the simple letter and first letter of each internal word capitalized.
//First non comment line in this java class is package and import.
//Constants define by all Uppercase letters and they are separated by the _(underscore).

