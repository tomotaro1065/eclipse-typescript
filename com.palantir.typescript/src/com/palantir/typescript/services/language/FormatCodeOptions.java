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
public final class FormatCodeOptions extends EditorOptions {

    @JsonProperty("InsertSpaceAfterCommaDelimiter")
    private boolean insertSpaceAfterCommaDelimiter;

    @JsonProperty("InsertSpaceAfterSemicolonInForStatements")
    private boolean insertSpaceAfterSemicolonInForStatements;

    @JsonProperty("InsertSpaceBeforeAndAfterBinaryOperators")
    private boolean insertSpaceBeforeAndAfterBinaryOperators;

    @JsonProperty("InsertSpaceAfterKeywordsInControlFlowStatements")
    private boolean insertSpaceAfterKeywordsInControlFlowStatements;

    @JsonProperty("InsertSpaceAfterFunctionKeywordForAnonymousFunctions")
    private boolean insertSpaceAfterFunctionKeywordForAnonymousFunctions;

    @JsonProperty("InsertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis")
    private boolean insertSpaceAfterOpeningAndBeforeClosingNonemptyParenthesis;

    @JsonProperty("PlaceOpenBraceOnNewLineForFunctions")
    private boolean placeOpenBraceOnNewLineForFunctions;

    @JsonProperty("PlaceOpenBraceOnNewLineForControlBlocks")
    private boolean placeOpenBraceOnNewLineForControlBlocks;

    public FormatCodeOptions() {
        this.insertSpaceAfterCommaDelimiter = true;
        this.insertSpaceAfterSemicolonInForStatements = true;
        this.insertSpaceBeforeAndAfterBinaryOperators = true;
        this.insertSpaceAfterKeywordsInControlFlowStatements = true;
    }
}
