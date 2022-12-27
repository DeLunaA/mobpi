package com.example.pi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    UserDB db  = new UserDB(Main2Activity.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main2);


        Button ins = findViewById(R.id.btninscri2);


        ins.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)  {




                EditText nome = findViewById(R.id.enom);
                EditText prenome = findViewById(R.id.eprenom);
                EditText tele = findViewById(R.id.etel);
                EditText emaile = findViewById(R.id.eemail);
                EditText mdpe = findViewById(R.id.emdp);


                TextView Nomerr = findViewById(R.id.Noommerr);


                Boolean ok = Boolean.TRUE;

                String nomm = nome.getText().toString();
                String prenomm = prenome.getText().toString();
                String tell = tele.getText().toString();
                String emaill = emaile.getText().toString();
                String mdpp = mdpe.getText().toString();



                String errormessage = "tous les champs sans requies !";


                if (nomm.matches("")) {
                    Nomerr.setText(errormessage);
                    ok = Boolean.FALSE;

                } else {

                    Nomerr.setText("");

                }
                //--
                if (prenomm.matches("")) {
                    Nomerr.setText(errormessage);
                    ok = Boolean.FALSE;

                } else {

                    Nomerr.setText("");

                }
                //--
                if (tell.matches("")) {
                    Nomerr.setText(errormessage);
                    ok = Boolean.FALSE;

                } else {

                    Nomerr.setText("");

                }
                //--
                if (emaill.matches("")) {
                    Nomerr.setText(errormessage);
                    ok = Boolean.FALSE;

                } else {

                    Nomerr.setText("");

                }

                if (mdpp.matches("")) {
                    Nomerr.setText(errormessage);
                    ok = Boolean.FALSE;

                } else {

                    Nomerr.setText("");

                }


                if (ok) {







                    db.open();

                    User u1 = new User(nome.getText().toString(),prenome.getText().toString(),tele.getText().toString(), emaile.getText().toString(), mdpe.getText().toString());     ///  u1 will be created with the essential infos once insc has been clicked

                    db.insertUser(u1);

                    db.close();


/*
                                         if (checku == false ){

                                                User1 u1 = new User1();     ///  u1 will be created with the essential infos once insc has been clicked
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









                                            }
*/



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