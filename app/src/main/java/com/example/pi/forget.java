package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forget extends AppCompatActivity {

    EditText emaill;
    Button bfor;
    UserDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forget);


        emaill=findViewById(R.id.zemail);
        bfor=findViewById(R.id.btnforget);
        db=new UserDB(this);

        bfor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = emaill.getText().toString();
                db.open();
                Boolean checkuserr=db.checkuserEmail(user);
                if(checkuserr==true)
                {
                    Intent intent = new Intent(forget.this ,ResetActivity.class);
                    intent.putExtra("Email",user);
                    startActivity(intent);

                }else
                {
                    Toast.makeText(forget.this,"User does not existe",Toast.LENGTH_SHORT).show();

                }


            }
        });



    }
}














