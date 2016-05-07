/*
 * Copyright 2015, The Android Open Source Project
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

package com.example.android.testing.notes.notes;

import com.example.android.testing.notes.data.Note;
import com.example.android.testing.notes.data.NotesRepository.LoadNotesCallback;
import com.google.common.collect.Lists;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

public class NotesPresenter_loadNotes_Test extends NotesPresenter__Test {

    private static List<Note> NOTES = Lists.newArrayList(new Note("Title1", "Description1"),
            new Note("Title2", "Description2"));

    private static List<Note> EMPTY_NOTES = new ArrayList<>(0);

    @Captor
    private ArgumentCaptor<LoadNotesCallback> mLoadNotesCallbackCaptor;

    @Test
    public void turnsOnProgressIndicator() {
        mNotesPresenter.loadNotes(true);
        verify(mNotesView).setProgressIndicator(true);
    }

    @Test
    public void queriesRepositoryForNotes() {
        mNotesPresenter.loadNotes(true);
        verify(mNotesRepository).getNotes(any(LoadNotesCallback.class));
    }

    @Test
    public void whenRepositoryReturnsNotes_showsNotes() {
        mNotesPresenter.loadNotes(true);
        verify(mNotesRepository).getNotes(mLoadNotesCallbackCaptor.capture());
        mLoadNotesCallbackCaptor.getValue().onNotesLoaded(NOTES);
        verify(mNotesView).showNotes(NOTES);
    }

    @Test
    public void whenRepositoryReturnsNotes_turnsOffProgressIndicator() {
        mNotesPresenter.loadNotes(true);
        verify(mNotesRepository).getNotes(mLoadNotesCallbackCaptor.capture());
        mLoadNotesCallbackCaptor.getValue().onNotesLoaded(NOTES);
        verify(mNotesView).setProgressIndicator(false);
    }
}
