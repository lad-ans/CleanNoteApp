package io.ladans.cleannoteapp.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ladans.cleannoteapp.feature_note.data.data_sources.NoteDatabase
import io.ladans.cleannoteapp.feature_note.data.repositories.NoteRepository
import io.ladans.cleannoteapp.feature_note.domain.repositories.INoteRepository
import io.ladans.cleannoteapp.feature_note.domain.use_cases.AddNote
import io.ladans.cleannoteapp.feature_note.domain.use_cases.DeleteNote
import io.ladans.cleannoteapp.feature_note.domain.use_cases.GetNotes
import io.ladans.cleannoteapp.feature_note.domain.use_cases.NoteUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): INoteRepository {
        return NoteRepository(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: INoteRepository): NoteUseCase {
        return NoteUseCase(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
        )
    }
}