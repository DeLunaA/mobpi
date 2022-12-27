package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button eLogin;
    private Button btni;

    private EditText eName;
    private EditText ePassword;
    private TextView txterroruser;
    UserDB db  = new UserDB(MainActivity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.loginpage);



        eName = findViewById(R.id.txtuser);

        ePassword =  findViewById(R.id.txtpwd);

        eLogin = findViewById(R.id.btninscri2);

        btni=findViewById(R.id.btnn);

        btni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent act20 = new Intent(MainActivity.this ,Main2Activity.class);
                startActivity(act20);
            }
        });

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtuserjava = findViewById(R.id.txtuser);
                EditText txtpwdjava = findViewById(R.id.txtpwd);

                String email = txtuserjava.getText().toString();
                String mdp = txtpwdjava.getText().toString();

                TextView errusername = findViewById(R.id.txtuser);
                TextView errpass = findViewById(R.id.txtpwd);

                String errormessage = "tous les champs sans requies !";


                Boolean valid = Boolean.TRUE;

                if(email.matches("")){
                    errusername.setText("Ce champ est requis.");
                    valid = Boolean.FALSE; }
                //erroremail.setPadding(0,5,0,10);
                else{
                    errusername.setText("");}



                if(mdp.matches("")){
                    errpass.setText("Ce champ est requis.");
                    valid=Boolean.FALSE;}
                //errormdp.setPadding(0,5,0,10);
                else{
                    errpass.setText("");}


                if(valid){

                    db.open();

                    Boolean checkuspass = db.checkuserpass(email,mdp);

                    db.close();

                    if (checkuspass==true){
                        Toast.makeText(MainActivity.this,"login succss",Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(MainActivity.this,"invalide credent",Toast.LENGTH_SHORT).show();

                    }

                }



            }
        });

        /*
        User user1 = new User("user1","pass","123","user","admin");
        UserDB database = new UserDB(getApplicationContext());

        database.open();
        database.insertUser(user1);


        User username = database.getUserWithEmail(user1.getEmail());
        if (username != null){
            Toast.makeText(MainActivity.this ,"user existe " ,Toast.LENGTH_SHORT ).show();
        }
        else
            Toast.makeText(MainActivity.this ,"user nexiste pas " ,Toast.LENGTH_SHORT ).show();

*/
    }
}