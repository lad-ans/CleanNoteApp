package io.ladans.cleannoteapp.feature_note.presentation.notes

import io.ladans.cleannoteapp.feature_note.domain.models.Note
import io.ladans.cleannoteapp.feature_note.domain.utils.NoteOrder
import io.ladans.cleannoteapp.feature_note.domain.utils.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
