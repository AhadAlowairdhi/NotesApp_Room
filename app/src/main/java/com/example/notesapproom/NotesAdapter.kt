package com.example.notesapproom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapproom.databinding.NoteRowBinding

class NotesAdapter(val activity: MainActivity , var notesList: List<Notes>): RecyclerView.Adapter<NotesAdapter.ItemViewHolder>() {
    class ItemViewHolder(var binding: NoteRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            NoteRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val aNote = notesList[position]

        holder.binding.apply {
            tvNote.text = aNote.note

            edtNote.setOnClickListener{
                activity.DialogEdit(aNote)
            }

            delNote.setOnClickListener{
                activity.DialogDel(aNote)
            }
        }
    }

    override fun getItemCount(): Int = notesList.size
}
