package com.example.android.testing.notes.addnote;

import com.example.android.testing.notes.NotesApp;
import com.example.android.testing.notes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = NotesApp.AppComponent.class, modules = AddNoteModule.class)
public interface AddNoteComponent {
    void inject(AddNoteContract.View addNoteView);
    AddNoteContract.UserActionsListener getUserActionsListener();
}
