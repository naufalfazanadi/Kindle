package edu.upi.mobprogproject.activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import edu.upi.mobprogproject.R;
import edu.upi.mobprogproject.helper.DbUsers;
import edu.upi.mobprogproject.model.Users;

public class SignupActivity extends AppCompatActivity {

    private EditText editTextNama;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    DbUsers dbU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbU = new DbUsers(getApplicationContext());
        dbU.open();

        //initializing views
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    public void registerUser(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //View view = getLayoutInflater().inflate(R.layout.progress);
        builder.setView(R.layout.progressbar);
        Dialog dialog = builder.create();
        dialog.show();

        //getting email and password from edit texts
        String nama = editTextNama.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        //checking if there is field empty
        if(TextUtils.isEmpty(nama)){
            Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,"Please enter username",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        Users u = new Users(username, email, password, nama);
        //creating a new user
        try{
            long rowInserted = dbU.insertUser(u);
            if(rowInserted != -1) {
                Toast.makeText(this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Username atau Password sudah ada", Toast.LENGTH_SHORT).show();
            }
            dialog.dismiss();
        }catch (android.database.SQLException e){
            dialog.dismiss();
            Toast.makeText(this,"Ada yang salah, hubungi developer",Toast.LENGTH_LONG).show();
            return;
        }

        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    public void toLogin(View view){
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbU.close();
    }
}
