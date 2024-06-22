package com.example.s2part2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Set;

public class NoteAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mNotes;
    private Set<String> mNotesSet;

    public NoteAdapter(Context context, ArrayList<String> notes, Set<String> notesSet) {
        super(context, 0, notes);
        mContext = context;
        mNotes = notes;
        mNotesSet = notesSet;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.note_item, parent, false);
        }

        String currentNote = mNotes.get(position);

        TextView noteTextView = listItem.findViewById(R.id.tvNotes);
        noteTextView.setText(currentNote);

        ImageView removeButton = listItem.findViewById(R.id.removeNote);
        removeButton.setOnClickListener(v -> {
            mNotesSet.remove(currentNote);
            mNotes.clear();
            mNotes.addAll(new ArrayList<>(mNotesSet));
            notifyDataSetChanged();
            ((NoteActivity) mContext).saveNotes();
        });

        return listItem;
    }
}
