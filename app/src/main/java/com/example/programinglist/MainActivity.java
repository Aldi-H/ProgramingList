package com.example.programinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

        programingListAdapter.setOnItemClickCallBack(new ProgramingListAdapter.OnItemClickCallBack() {
            @Override
            public void onItemClicked(Programing data) {
                showSelectedPrograming(data);
            }
        });
    }

    //Hanya untuk menandakan item yang dipilih
    private void showSelectedPrograming(Programing programing) {
        Toast.makeText(this, programing.getName(), Toast.LENGTH_SHORT).show();
    }

    //Menu item
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent profile = new Intent(MainActivity.this, Profile.class);
                startActivity(profile);
        }
        return super.onOptionsItemSelected(item);
    }
}