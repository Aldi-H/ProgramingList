package com.example.programinglist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements ProgramingListAdapter.OnClick {
    private RecyclerView rvPrograming;
    private ArrayList<Programing> list = new ArrayList<>();
    private Intent intent;

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
        ProgramingListAdapter programingListAdapter = new ProgramingListAdapter(list, this);
        rvPrograming.setAdapter(programingListAdapter);
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

    @Override
    public void onClick(int position) {
        switch (position) {
            case 0 :
                intent = new Intent(this, Activity_Java.class);
                startActivity(intent);
                break;
            case 1 :
                intent = new Intent(this, Activity_Dart.class);
                startActivity(intent);
                break;
            case 2 :
                intent = new Intent(this, Activity_Cpp.class);
                startActivity(intent);
                break;
            case 3 :
                intent = new Intent(this, Activity_Cs.class);
                startActivity(intent);
                break;
            case 4 :
                intent = new Intent(this, Activity_C.class);
                startActivity(intent);
                break;
            case 5 :
                intent = new Intent(this, Activity_Python.class);
                startActivity(intent);
                break;
            case 6 :
                intent = new Intent(this, Activity_JavaScript.class);
                break;
            case 7 :
                intent = new Intent(this, Activity_HTML.class);
                startActivity(intent);
                break;
            case 8 :
                intent = new Intent(this, Activity_Ruby.class);
                startActivity(intent);
                break;
            case 9 :
                intent = new Intent(this, Activity_PHP.class);
                startActivity(intent);
                break;
        }
    }
}