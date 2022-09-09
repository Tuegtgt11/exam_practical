package com.example.vuductue_practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edUser, edDes, edEmail;
    Spinner spinner;
    CheckBox ckAgree;
    Button btSend;
    String gender = "Male";
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getAppDatabase(this);
        ckAgree = findViewById(R.id.ck);
        edUser = findViewById(R.id.edUser);
        edEmail = findViewById(R.id.edEmail);
        edDes = findViewById(R.id.edDes);
        spinner = findViewById(R.id.spinner);
        btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(this);
        String[] listGender = {"Male", "Female", "Unknow"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, listGender);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i,
                                       long l) {
                Log.d("TAG", "onItemSelected: " + listGender[i]);
                gender = listGender[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void onRegister() {
        if (!validate()) {
            return;
        }
        User user = new User();
        user.username = edUser.getText().toString();
        user.des = edDes.getText().toString();
        user.email = edEmail.getText().toString();
        user.gender = gender;
        long id = db.userDao().insertUser(user);
        if (id > 0) {
            Toast.makeText(this,"There're " + db.userDao().getAllUser().size() + " feedbacks in database",
                    Toast.LENGTH_SHORT).show();
        }
        /*goToListUser();*/
    }

   /* private void goToListUser() {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }*/

    private boolean validate() {
        String mes = null;
        if (edUser.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập Tên";
        } else if (edDes.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập Feedback";
        }
        else if (edEmail.getText().toString().trim().isEmpty()) {
            mes = "Chưa nhập Email";

        }else if (!ckAgree.isChecked()) {
            mes = "Bạn phải đồng ý điều khoản sử dụng";
        }
        if (mes != null) {
            Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btSend:
                onRegister();
                break;
            default:
                break;
        }
    }
}