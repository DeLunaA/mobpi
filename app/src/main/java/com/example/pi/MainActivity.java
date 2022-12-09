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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.connecter);

        Button btnconnectjava = findViewById(R.id.btnconnecter);
        btnconnectjava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtuserjava = findViewById(R.id.email);
                EditText txtpwdjava = findViewById(R.id.mdp);

                String email = txtuserjava.getText().toString();
                String mdp = txtpwdjava.getText().toString();

                String msg = email + " " + mdp;


                TextView erroremail = findViewById(R.id.erremail);
                TextView errormdp = findViewById(R.id.errmdp);

                Boolean valid = Boolean.TRUE;

                if(email.matches("")){
                    erroremail.setText("Ce champ est requis.");
                    valid = Boolean.FALSE; }
                //erroremail.setPadding(0,5,0,10);
                else
                    erroremail.setText("");



                if(mdp.matches("")){
                    errormdp.setText("Ce champ est requis.");
                    valid=Boolean.FALSE;}
                //errormdp.setPadding(0,5,0,10);
                else
                    errormdp.setVisibility(View.INVISIBLE);



                if(valid){
                    Intent Activity2 = new Intent(MainActivity.this, Activity2.class); //cree un lien activity 1 to 2
                    Activity2.putExtra("Email",email);
                    startActivity(Activity2);}


            }
        });

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


    }
}