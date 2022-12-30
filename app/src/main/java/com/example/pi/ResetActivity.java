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

    TextView txemaill;
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

        txemaill=findViewById(R.id.txtemail); //hedhi zone fergha
        newpass=findViewById(R.id.newmdp);
        confo=findViewById(R.id.conmdp);
        formp=findViewById(R.id.submitpass);
        db=new UserDB(ResetActivity.this);
        String haja = getIntent().getStringExtra("keyemail");



        formp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass=newpass.getText().toString();
                String repass=confo.getText().toString();

                if(pass.equals(repass)){
                    db.open();
                    Boolean check_pass_update=db.updatepass(haja,pass);
                    db.close();


                if (check_pass_update==true){
                    Intent intent = new Intent(ResetActivity.this ,loginpage.class);
                    startActivity(intent);
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