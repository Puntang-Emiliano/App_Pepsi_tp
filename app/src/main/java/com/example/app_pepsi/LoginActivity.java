package com.example.app_pepsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    Button btn_Iniciar;
    Button btn_Registrarse;
    EditText edtUsuario ,edtContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.login_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.generarUI();
    }


    private void generarUI() {
        // instancia de controles UI
        btn_Iniciar = findViewById(R.id.btn_Iniciar);
        btn_Registrarse = findViewById(R.id.btn_Registrarse);
        edtUsuario = findViewById(R.id.edtUsuario);
        edtContraseña = findViewById(R.id.edtContraseña);

        btn_Iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                login();
            }
        });

    }
    private void login() {
        String username = edtUsuario.getText().toString().trim();
        String password = edtContraseña.getText().toString().trim();

        if (username.equals("alumno") && password.equals("1234")) {

            Intent intent = new Intent(LoginActivity.this, PrincipalActivity.class);
            Toast.makeText(LoginActivity.this, R.string.bienvenido, Toast.LENGTH_LONG).show();
            startActivity(intent);
            finish();
        } else {

            Toast.makeText(this, "Nombre de usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

}


