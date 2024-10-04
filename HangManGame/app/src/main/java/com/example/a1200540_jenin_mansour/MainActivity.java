package com.example.a1200540_jenin_mansour;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Fname;
    private EditText Lname;
    private EditText stuId;
    private Button startButton;
    private String firstName;
    private String lastName;
    private String studentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fname = findViewById(R.id.Fname);
        Lname = findViewById(R.id.Lname);
        stuId = findViewById(R.id.stuid);
        startButton = findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int count = 0 ;

                if (Fname.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill your first name", Toast.LENGTH_SHORT).show();
                }else{

                    firstName = Fname.getText().toString();
                    count++;
                }

                if (Lname.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill your last name", Toast.LENGTH_SHORT).show();
                }else{
                    lastName = Lname.getText().toString();
                    count++;
                }

                if (stuId.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please fill your ID", Toast.LENGTH_SHORT).show();
                }else{
                    studentId = stuId.getText().toString();
                    count++;
                }
                if(count == 3) {
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                    intent.putExtra("firstName", firstName);
                    intent.putExtra("lastName", lastName);
                    intent.putExtra("studentId", studentId);
                    MainActivity.this.startActivity(intent);
                    finish();
                }


            }
        });
    }
}
