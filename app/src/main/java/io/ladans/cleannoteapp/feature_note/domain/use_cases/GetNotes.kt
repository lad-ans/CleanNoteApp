package io.ladans.cleannoteapp.feature_note.domain.use_cases

import io.ladans.cleannoteapp.feature_note.domain.models.Note
import io.ladans.cleannoteapp.feature_note.domain.repositories.INoteRepository
import io.ladans.cleannoteapp.feature_note.domain.utils.NoteOrder
import io.ladans.cleannoteapp.feature_note.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private  val repository: INoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map {
                notes ->  when(noteOrder.orderType) {
                    is OrderType.Ascending -> {
                        when(noteOrder) {
                            is NoteOrder.Title -> notes.sortedBy { it.title.lowercase()}
                            is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                            is NoteOrder.Color -> notes.sortedBy { it.color }
                        }
                    }
                    is OrderType.Descending -> {
                        when(noteOrder) {
                            is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                            is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                            is NoteOrder.Color -> notes.sortedBy { it.color }
                        }
                    }
                }
        }
    }
}