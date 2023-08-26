package io.ladans.cleannoteapp.feature_note.domain.use_cases

data class NoteUseCase(
    val getNotes: GetNotes,
    val deleteNote: DeleteNote,
    val addNote: AddNote
)
