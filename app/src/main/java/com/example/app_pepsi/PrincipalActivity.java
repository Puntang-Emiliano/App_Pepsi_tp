package com.example.app_pepsi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PrincipalActivity extends AppCompatActivity {

    Button btnAcercade ,btnSalir;
    ImageButton ibtnFacebook, ibtnGmail,ibtnWhatsaap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        generarUI();
    }
    private void generarUI() {

        btnAcercade = findViewById(R.id.btnAcerca);
        btnSalir = findViewById(R.id.btnSalir);
        ibtnGmail = findViewById(R.id.ibtnGmail);
        ibtnFacebook = findViewById(R.id.ibtnFacebook);
        ibtnWhatsaap = findViewById(R.id.ibtnWhatsaap);

        btnAcercade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), AcercaDe_Activity.class);
                startActivity(intent);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });



        ibtnWhatsaap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://wa.me/542954000095";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        ImageButton ibtnFacebook = findViewById(R.id.ibtnFacebook);

        ibtnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://www.facebook.com/pepsiargentina/";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });


        ibtnGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = "puntang.emiliano@gmail.com";
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                Uri _email = Uri.parse("mailto:" + email);
                intent.setData(_email);
                startActivity(intent);
            }
        });




    }

}
