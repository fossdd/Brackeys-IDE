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

package com.brackeys.ui.feature.settings.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.brackeys.ui.R
import com.brackeys.ui.data.settings.SettingsManager
import com.brackeys.ui.data.utils.schedulersIoToMain
import com.brackeys.ui.domain.providers.rx.SchedulersProvider
import com.brackeys.ui.feature.base.viewmodel.BaseViewModel
import com.brackeys.ui.feature.settings.adapters.item.PreferenceItem
import com.brackeys.ui.utils.event.SingleLiveEvent
import com.f2prateek.rx.preferences2.Preference
import io.reactivex.rxkotlin.subscribeBy

class SettingsViewModel @ViewModelInject constructor(
    private val schedulersProvider: SchedulersProvider,
    private val settingsManager: SettingsManager
) : BaseViewModel() {

    val fullscreenEvent: SingleLiveEvent<Boolean> = SingleLiveEvent() // Полноэкранный режим
    val headersEvent: MutableLiveData<List<PreferenceItem>> = MutableLiveData()

    var keyboardPreset: Preference<String> = settingsManager.getKeyboardPreset()

    fun fetchHeaders() {
        headersEvent.value = listOf(
            PreferenceItem(
                R.string.pref_header_application_title,
                R.string.pref_header_application_summary,
                R.id.applicationFragment
            ),
            PreferenceItem(
                R.string.pref_header_editor_title,
                R.string.pref_header_editor_summary,
                R.id.editorFragment
            ),
            PreferenceItem(
                R.string.pref_header_codeStyle_title,
                R.string.pref_header_codeStyle_summary,
                R.id.codeStyleFragment
            ),
            PreferenceItem(
                R.string.pref_header_files_title,
                R.string.pref_header_files_summary,
                R.id.filesFragment
            ),
            PreferenceItem(
                R.string.pref_header_about_title,
                R.string.pref_header_about_summary,
                R.id.aboutFragment
            )
        )
    }

    fun observeSettings() {
        settingsManager.getFullscreenMode()
            .asObservable()
            .schedulersIoToMain(schedulersProvider)
            .subscribeBy { fullscreenEvent.value = it }
            .disposeOnViewModelDestroy()
    }
}