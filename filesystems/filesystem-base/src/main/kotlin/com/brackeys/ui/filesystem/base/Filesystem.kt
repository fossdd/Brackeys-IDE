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

package com.brackeys.ui.filesystem.base

import com.brackeys.ui.filesystem.base.model.FileModel
import com.brackeys.ui.filesystem.base.model.FileParams
import com.brackeys.ui.filesystem.base.model.FileTree
import com.brackeys.ui.filesystem.base.model.PropertiesModel
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface Filesystem {
    fun defaultLocation(): Single<FileTree>
    fun provideDirectory(parent: FileModel?): Single<FileTree>

    fun createFile(fileModel: FileModel): Single<FileModel>
    fun renameFile(fileModel: FileModel, fileName: String): Single<FileModel>
    fun deleteFile(fileModel: FileModel): Single<FileModel>
    fun copyFile(source: FileModel, dest: FileModel): Single<FileModel>
    fun propertiesOf(fileModel: FileModel): Single<PropertiesModel>

    fun compress(source: List<FileModel>, dest: FileModel, archiveName: String): Observable<FileModel>
    fun extractAll(source: FileModel, dest: FileModel): Single<FileModel>

    fun loadFile(fileModel: FileModel, fileParams: FileParams): Single<String>
    fun saveFile(fileModel: FileModel, text: String, fileParams: FileParams): Completable
}