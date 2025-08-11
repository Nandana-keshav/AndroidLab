package com.example.uicontrols;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, phone, email, age, password;
    RadioGroup genderGroup;
    CheckBox dancing, singing, reading, playing;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.editTextUsername);
        phone = findViewById(R.id.editTextPhone);
        email = findViewById(R.id.editTextEmail);
        age = findViewById(R.id.editTextAge);
        password = findViewById(R.id.editTextPassword);
        genderGroup = findViewById(R.id.genderGroup);
        dancing = findViewById(R.id.checkBoxDancing);
        singing = findViewById(R.id.checkBoxSinging);
        reading = findViewById(R.id.checkBoxReading);
        playing = findViewById(R.id.checkBoxPlaying);
        submitButton = findViewById(R.id.buttonSubmit);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String user = username.getText().toString().trim();
                String phoneNo = phone.getText().toString().trim();
                String mail = email.getText().toString().trim();
                String userAge = age.getText().toString().trim();
                String userPassword = password.getText().toString().trim();


                if (user.isEmpty() || user.length() < 3) {
                    username.setError("Username must be at least 3 characters");
                    username.requestFocus();
                    return;
                }


                if (!phoneNo.matches("\\d{10}")) {
                    phone.setError("Enter a valid 10-digit phone number");
                    phone.requestFocus();
                    return;
                }


                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                    email.setError("Enter a valid email address");
                    email.requestFocus();
                    return;
                }


                if (userAge.isEmpty() || !userAge.matches("\\d+")) {
                    age.setError("Enter a valid age");
                    age.requestFocus();
                    return;
                } else {
                    int ageVal = Integer.parseInt(userAge);
                    if (ageVal < 1 || ageVal > 120) {
                        age.setError("Age must be between 1 and 120");
                        age.requestFocus();
                        return;
                    }
                }


                if (userPassword.length() < 6) {
                    password.setError("Password must be at least 6 characters");
                    password.requestFocus();
                    return;
                }


                int selectedGenderId = genderGroup.getCheckedRadioButtonId();
                String gender = "";
                if (selectedGenderId != -1) {
                    RadioButton selectedGender = findViewById(selectedGenderId);
                    gender = selectedGender.getText().toString();
                } else {
                    Toast.makeText(MainActivity.this, "Please select a gender", Toast.LENGTH_SHORT).show();
                    return;
                }


                StringBuilder hobbies = new StringBuilder();
                if (dancing.isChecked()) hobbies.append("Dancing ");
                if (singing.isChecked()) hobbies.append("Singing ");
                if (reading.isChecked()) hobbies.append("Reading ");
                if (playing.isChecked()) hobbies.append("Playing ");


                String result = "Username: " + user +
                        "\nPhone: " + phoneNo +
                        "\nEmail: " + mail +
                        "\nAge: " + userAge +
                        "\nPassword: " + userPassword +
                        "\nGender: " + gender +
                        "\nHobbies: " + hobbies.toString();

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
            }
        });
    }
}
