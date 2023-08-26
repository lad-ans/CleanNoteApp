package io.ladans.cleannoteapp.feature_note.domain.models

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.ladans.cleannoteapp.ui.theme.BabyBlue
import io.ladans.cleannoteapp.ui.theme.LightGreen
import io.ladans.cleannoteapp.ui.theme.RedOrange
import io.ladans.cleannoteapp.ui.theme.RedPink
import io.ladans.cleannoteapp.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int?
) {
    companion object {
        val noteColors = listOf<Color>(
            RedOrange,
            LightGreen,
            Violet,
            BabyBlue,
            RedPink
        )
    }
}


class InvalidNoteException(message: String) : Exception(message)