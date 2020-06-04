package com.example.programinglist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvPrograming;
    private ArrayList<Programing> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPrograming = findViewById(R.id.rv_programings);
        rvPrograming.setHasFixedSize(true);

        //Menampilkan method showRecycleList()
        list.addAll(ProgramingData.getListData());
        showRecycleList();
    }

    //Memanggil data dari kelas ProgramingData
    private void showRecycleList() {
        rvPrograming.setLayoutManager(new LinearLayoutManager(this));
        ProgramingListAdapter programingListAdapter = new ProgramingListAdapter(list);
        rvPrograming.setAdapter(programingListAdapter);
    }
}