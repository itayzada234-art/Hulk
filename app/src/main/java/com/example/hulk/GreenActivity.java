package com.example.hulk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_green);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvMsg = findViewById(R.id.tvMsg);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("Message")) {
            String message = intent.getStringExtra("Message");
            if (message != null && !message.isEmpty()) {
                tvMsg.setText("Message from Blue:\n" + message);
            }
        }

        EditText etGreen = findViewById(R.id.etGreen);
        Button btnGoToBlue = findViewById(R.id.btnGoToBlue);
        btnGoToBlue.setOnClickListener(v -> {
            String message = etGreen.getText().toString();
            Intent blueIntent = new Intent(GreenActivity.this, BlueActivity.class);
            blueIntent.putExtra("Message", message);
            startActivity(blueIntent);
        });
    }
}
