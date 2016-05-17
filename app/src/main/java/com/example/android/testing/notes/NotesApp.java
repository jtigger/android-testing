package com.example.android.testing.notes;

import android.app.Application;

import com.example.android.testing.notes.data.NotesRepository;
import com.example.android.testing.notes.data.NotesRepositoryModule;

import javax.inject.Inject;
import javax.inject.Singleton;

public class NotesApp extends Application {
    @Inject
    NotesRepository mNotesRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerNotesApp_AppComponent.builder().build();
        mAppComponent.inject(this);
    }

    @Singleton
    @dagger.Component(modules = NotesRepositoryModule.class)
    public interface AppComponent {
        NotesRepository getNotesRepository();
        void inject(NotesApp notesApp);
    }
    public AppComponent component() {
        return mAppComponent;
    }
    private AppComponent mAppComponent;

}
