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

public class BlueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blue);
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
                tvMsg.setText("Message from Green:\n" + message);
            }
        }

        EditText etBlue = findViewById(R.id.etBlue);
        Button btnGoToGreen = findViewById(R.id.btnGoToGreen);
        btnGoToGreen.setOnClickListener(v -> {
            String message = etBlue.getText().toString();
            Intent greenIntent = new Intent(BlueActivity.this, GreenActivity.class);
            greenIntent.putExtra("Message", message);
            startActivity(greenIntent);
        });
    }
}
