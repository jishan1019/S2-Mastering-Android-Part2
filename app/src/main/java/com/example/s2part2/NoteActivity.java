package com.example.s2part2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NoteActivity extends AppCompatActivity {

    private EditText editTextNote;
    private ListView listViewNotes;
    private NoteAdapter notesAdapter;
    private Set<String> notesSet;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        // Initialize views
        editTextNote = findViewById(R.id.editTextNote);
        listViewNotes = findViewById(R.id.listViewNotes);

        // Initialize SharedPreferences to store notes
        sharedPreferences = getSharedPreferences("notes", MODE_PRIVATE);
        notesSet = sharedPreferences.getStringSet("notesSet", new HashSet<String>());

        // Initialize ListView adapter with custom adapter
        notesAdapter = new NoteAdapter(this, new ArrayList<>(notesSet), notesSet);
        listViewNotes.setAdapter(notesAdapter);
    }

    public void addNote(View view) {
        String noteText = editTextNote.getText().toString().trim();

        if (!noteText.isEmpty()) {
            // Add new note to Set and update ListView
            notesSet.add(noteText);
            notesAdapter.clear();
            notesAdapter.addAll(new ArrayList<>(notesSet));
            notesAdapter.notifyDataSetChanged();
            saveNotes();

            // Clear EditText
            editTextNote.getText().clear();
        } else {
            Toast.makeText(this, "Please enter a note", Toast.LENGTH_SHORT).show();
        }
    }

    // Save notes to SharedPreferences
    public void saveNotes() {
        sharedPreferences.edit().putStringSet("notesSet", notesSet).apply();
    }
}
