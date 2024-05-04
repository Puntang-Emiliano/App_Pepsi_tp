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

public class AcercaDe_Activity extends AppCompatActivity {

    Button btn_principal;
    ImageButton ibtnGmail,ibtnTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_acerca_de);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        generarUI();
    }

    private void generarUI() {
        btn_principal = findViewById(R.id.btn_principal);
        ibtnGmail = findViewById(R.id.ibtnGmail);
        ibtnTelefono = findViewById(R.id.ibtnTelefono);

        btn_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AcercaDe_Activity.this, PrincipalActivity.class);
                startActivity(intent);
                finish();
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



        ibtnTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String telefono = "2954000095";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + telefono));
                startActivity(intent);
            }
        });



    }


}
