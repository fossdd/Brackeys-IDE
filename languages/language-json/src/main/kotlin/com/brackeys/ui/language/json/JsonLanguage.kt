/*
 * Copyright 2020 Brackeys IDE contributors.
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

package com.brackeys.ui.language.json

import com.brackeys.ui.language.base.Language
import com.brackeys.ui.language.base.parser.LanguageParser
import com.brackeys.ui.language.base.provider.SuggestionProvider
import com.brackeys.ui.language.base.styler.LanguageStyler
import com.brackeys.ui.language.json.parser.JsonParser
import com.brackeys.ui.language.json.provider.JsonProvider
import com.brackeys.ui.language.json.styler.JsonStyler

class JsonLanguage : Language {

    companion object {

        private const val FILE_EXTENSION = ".json"

        fun supportFormat(fileName: String): Boolean {
            return fileName.endsWith(FILE_EXTENSION, ignoreCase = true)
        }
    }

    override fun getName(): String {
        return "json"
    }

    override fun getParser(): LanguageParser {
        return JsonParser.getInstance()
    }

    override fun getProvider(): SuggestionProvider {
        return JsonProvider.getInstance()
    }

    override fun getStyler(): LanguageStyler {
        return JsonStyler.getInstance()
    }
}