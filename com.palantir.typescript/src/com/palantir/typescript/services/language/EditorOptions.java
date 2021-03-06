/*
 * Copyright 2013 Palantir Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.palantir.typescript.services.language;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Corresponds to the class with the same name in languageService.ts.
 *
 * @author dcicerone
 */
public class EditorOptions {

    @JsonProperty("IndentSize")
    private int indentSize;

    @JsonProperty("TabSize")
    private int tabSize;

    @JsonProperty("NewLineCharacter")
    private String newLineCharacter;

    @JsonProperty("ConvertTabsToSpaces")
    private boolean convertTabsToSpaces;

    public EditorOptions() {
        this.indentSize = 4;
        this.tabSize = 4;
        this.newLineCharacter = System.getProperty("line.separator");
        this.convertTabsToSpaces = true;
    }
}
