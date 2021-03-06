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

package com.palantir.typescript.text.actions;

import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.source.ISourceViewer;

import com.palantir.typescript.text.TypeScriptEditor;

/**
 * Formats the selected code.
 *
 * @author dcicerone
 */
public final class FormatAction extends TypeScriptEditorAction {

    public FormatAction(TypeScriptEditor editor) {
        super(editor);
    }

    @Override
    public void run() {
        ITextOperationTarget textOperationTarget = this.getTextOperationTarget();

        textOperationTarget.doOperation(ISourceViewer.FORMAT);
    }
}
