package com.example.vuductue_practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class ListUserActivity extends AppCompatActivity {

    RecyclerView rvUser;
    AppDatabase db;
    Button btCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        db = AppDatabase.getAppDatabase(this);
        List<User> list = db.userDao().getAllUser();
        UserAdapter adapter = new UserAdapter(this, list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        rvUser = findViewById(R.id.rvUser);
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(adapter);
    }
}