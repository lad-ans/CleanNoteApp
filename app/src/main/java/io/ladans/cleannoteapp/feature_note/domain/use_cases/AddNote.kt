package io.ladans.cleannoteapp.feature_note.domain.use_cases

import io.ladans.cleannoteapp.feature_note.domain.models.InvalidNoteException
import io.ladans.cleannoteapp.feature_note.domain.models.Note
import io.ladans.cleannoteapp.feature_note.domain.repositories.INoteRepository

class AddNote(
    private val repository: INoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("O título da nota não pode estar vazio")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("O conteúdo da nota não pode estar vazio")
        }
        repository.insertNote(note)
    }
}