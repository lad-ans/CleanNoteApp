package io.ladans.cleannoteapp.feature_note.domain.use_cases

import io.ladans.cleannoteapp.feature_note.domain.models.Note
import io.ladans.cleannoteapp.feature_note.domain.repositories.INoteRepository

class DeleteNote(val repository: INoteRepository) {
    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}