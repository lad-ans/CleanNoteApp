package io.ladans.cleannoteapp.feature_note.data.data_sources

import androidx.room.Database
import androidx.room.RoomDatabase
import io.ladans.cleannoteapp.feature_note.domain.models.Note

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract  val noteDao: NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"
    }
}