package io.ladans.cleannoteapp.feature_note.domain.repositories

import io.ladans.cleannoteapp.feature_note.domain.models.Note
import kotlinx.coroutines.flow.Flow

interface INoteRepository {
    fun getNotes(): Flow<List<Note>>

    suspend fun getNoteById(id: Int): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}