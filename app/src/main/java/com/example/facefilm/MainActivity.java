package com.example.facefilm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    EditText ed_room;
    Button btn_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_room=findViewById(R.id.ed_room);
        btn_join=findViewById(R.id.btn_join);

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed_room.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter a room id", Toast.LENGTH_SHORT).show();
                }else
                {
                    try {
                        JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                                .setServerURL(new URL("https://meet.jit.si"))
                                .setRoom(ed_room.getText().toString())

                                .setAudioOnly(true)
                                .setWelcomePageEnabled(true)
                                .build();

                        JitsiMeetActivity.launch(MainActivity.this,options);
                    } catch(MalformedURLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}