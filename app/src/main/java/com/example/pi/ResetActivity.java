package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {

    TextView emaill;
    EditText confo;
    EditText newpass;
    Button formp;
    UserDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_reset);

        emaill=findViewById(R.id.txtemail); //hedhi zone fergha
        newpass=findViewById(R.id.newmdp);
        confo=findViewById(R.id.conmdp);
        formp=findViewById(R.id.submitpass);
        db=new UserDB(this);

        Intent intent=getIntent();
        emaill.setText(intent.getStringExtra("emaill"));


        formp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String eemail=emaill.getText().toString();
                String pass=newpass.getText().toString();
                String repass=confo.getText().toString();

                if(pass.equals(repass)){
                    db.open();

                Boolean check_pass_update=db.updatepass(eemail,pass);
                if (check_pass_update==true){
                    Intent intent1=new Intent(ResetActivity.this,loginpage.class);
                    startActivity(intent1);
                    Toast.makeText(ResetActivity.this, "Password updated successfuly",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ResetActivity.this, "Password not updated",Toast.LENGTH_SHORT).show();
                }

            }
                else{
                    Toast.makeText(ResetActivity.this, "Password not matched",Toast.LENGTH_SHORT).show();


                }
            }
        });



    }
}