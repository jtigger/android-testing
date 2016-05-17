package com.example.android.testing.notes.addnote;

import com.example.android.testing.notes.data.NotesRepository;
import com.example.android.testing.notes.util.FakeImageFileImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class AddNoteModule {
    private final AddNoteContract.View mAddNoteView;

    public AddNoteModule(AddNoteContract.View addNoteView) {
        mAddNoteView = addNoteView;
    }

    @Provides
    public AddNoteContract.UserActionsListener provideUserActionListener(NotesRepository notesRepository) {
        return new AddNotePresenter(notesRepository, mAddNoteView, new FakeImageFileImpl());
    }

    @Provides
    public AddNoteContract.View provideView() {
        return mAddNoteView;
    }
}
