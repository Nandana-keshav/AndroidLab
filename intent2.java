package com.example.prgm4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private TextView displayInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // Ensure this layout file exists

        displayInfo = findViewById(R.id.textViewDisplay); // Ensure this ID exists in activity_main2.xml

        // Retrieve from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        String name = prefs.getString("name", "N/A");
        String email = prefs.getString("email", "N/A");
        String phone = prefs.getString("phone", "N/A");
        String age = prefs.getString("age", "N/A");

        String info = String.format(
                "👤 Name: %s\n📧 Email: %s\n📞 Phone: %s\n🎂 Age: %s",
                name, email, phone, age
        );

        displayInfo.setText(info);
    }
}
