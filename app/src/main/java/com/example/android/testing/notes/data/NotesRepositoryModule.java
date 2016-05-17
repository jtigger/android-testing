package com.example.android.testing.notes.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NotesRepositoryModule {

    @Provides
    @Singleton
    public NotesRepository provideInMemoryRepo() {
        return NoteRepositories.getInMemoryRepoInstance(new FakeNotesServiceApiImpl());
    }
}
