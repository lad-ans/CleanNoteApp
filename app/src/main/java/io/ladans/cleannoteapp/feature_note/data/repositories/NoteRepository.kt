package io.ladans.cleannoteapp.feature_note.data.repositories

import io.ladans.cleannoteapp.feature_note.data.data_sources.NoteDao
import io.ladans.cleannoteapp.feature_note.domain.models.Note
import io.ladans.cleannoteapp.feature_note.domain.repositories.INoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepository(
    private val dao: NoteDao
) : INoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes();
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }
}