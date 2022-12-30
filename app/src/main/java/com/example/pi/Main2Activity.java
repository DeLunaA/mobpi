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

public class Main2Activity extends AppCompatActivity {

    UserDB db  = new UserDB(Main2Activity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);


        Button ins = findViewById(R.id.btnforget);


        ins.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)  {

                EditText nome = findViewById(R.id.enom);
                EditText eprenom = findViewById(R.id.eprenom);
                EditText etel = findViewById(R.id.etel);
                EditText eemail = findViewById(R.id.eemail);
                EditText emdp = findViewById(R.id.emdp);


                TextView Nomerr = findViewById(R.id.Noommerr);


                Boolean ok = Boolean.TRUE;

                String nomm = nome.getText().toString();
                String prenomm = eprenom.getText().toString();
                String tell = etel.getText().toString();
                String emaill = eemail.getText().toString();
                String mdpp = emdp.getText().toString();



                if (nomm.matches("")) {
                    Toast.makeText(Main2Activity.this, "Name requied",Toast.LENGTH_SHORT).show();
                    ok = Boolean.FALSE;
                }

                if (prenomm.matches("")) {
                    Toast.makeText(Main2Activity.this, "Last name requied",Toast.LENGTH_SHORT).show();
                    ok = Boolean.FALSE;

                }

                if (tell.matches("")) {
                    Toast.makeText(Main2Activity.this, "Phone number requied",Toast.LENGTH_SHORT).show();
                    ok = Boolean.FALSE;
                    }


                if (emaill.matches("")) {
                    Toast.makeText(Main2Activity.this, "Emaill number requied",Toast.LENGTH_SHORT).show();
                    ok = Boolean.FALSE;

                }

                if (mdpp.matches("")) {
                    Toast.makeText(Main2Activity.this, "Password number requied",Toast.LENGTH_SHORT).show();
                    ok = Boolean.FALSE;

                }

                if (ok) {
                    db.open();
                    Boolean  checktel =  db.checkusertel(tell);
                    db.close();
                    if (checktel==false){
                        db.open();
                        User u1 = new User(etel.getText().toString(),eprenom.getText().toString(),nome.getText().toString(), eemail.getText().toString(), emdp.getText().toString());     ///  u1 will be created with the essential infos once insc has been clicked
                        db.insertUser(u1);
                        db.close();

                        Intent act20 = new Intent(Main2Activity.this ,loginpage.class);
                        startActivity(act20);
                        Toast.makeText(Main2Activity.this,"Account created with success",Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(Main2Activity.this,"this phone number is already exist ",Toast.LENGTH_SHORT).show();

                    }





                    /*if (checku == false ){
                        User1 u1 = new User1();
                        Toast.makeText(Activity2.this,"pcheww ",Toast.LENGTH_SHORT).show();

                        u1.setNumT(numt.getText().toString());
                        u1.setNom(Nom.getText().toString());
                        u1.setAddresse(ads.getText().toString());
                        u1.setMps(pss.getText().toString());

                        db.open();

                        Long checkinss =   db.insertUser(u1);

                        if ( checkinss == 0){
                            Toast.makeText(Activity2.this,"inscription faied ",Toast.LENGTH_SHORT).show();
                            db.close();
                        }
                        else{
                            Toast.makeText(Activity2.this,"inscription ok ",Toast.LENGTH_SHORT).show();
                            db.close();


                        }

                    }*/




//                                 User1 u1 = new User1();     ///  u1 will be created with the essential infos once insc has been clicked


                }




                //
                //         TextView  m  = findViewById(R.id.msg);
                // Bundle bundle = getIntent().getExtras();

                //  if(bundle !=null){
                //  String username = bundle.getString("username");
                //    String password = bundle.getString("pasw");

                //m.setText(username +" "+password );

                // }




            }});}}