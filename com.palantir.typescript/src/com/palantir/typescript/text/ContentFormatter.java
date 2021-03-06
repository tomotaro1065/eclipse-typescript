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

package com.palantir.typescript.text;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.formatter.IContentFormatter;
import org.eclipse.jface.text.formatter.IFormattingStrategy;

import com.google.common.collect.Lists;
import com.palantir.typescript.services.language.FormatCodeOptions;
import com.palantir.typescript.services.language.LanguageService;
import com.palantir.typescript.services.language.TextEdit;

/**
 * The TypeScript formatter.
 *
 * @author dcicerone
 */
public final class ContentFormatter implements IContentFormatter {

    private final TypeScriptEditor editor;

    public ContentFormatter(TypeScriptEditor editor) {
        checkNotNull(editor);

        this.editor = editor;
    }

    @Override
    public void format(IDocument document, IRegion region) {
        String fileName = this.editor.getFileName();
        int minChar = region.getOffset();
        int limChar = minChar + region.getLength();
        FormatCodeOptions options = new FormatCodeOptions();
        LanguageService languageService = this.editor.getLanguageService();
        List<TextEdit> edits = languageService.getFormattingEditsForRange(fileName, minChar, limChar, options);

        // apply the edits
        try {
            for (TextEdit edit : Lists.reverse(edits)) {
                int offset = edit.getMinChar();
                int length = edit.getLimChar() - offset;
                String text = edit.getText();

                document.replace(offset, length, text);
            }
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IFormattingStrategy getFormattingStrategy(String contentType) {
        throw new UnsupportedOperationException();
    }
}
