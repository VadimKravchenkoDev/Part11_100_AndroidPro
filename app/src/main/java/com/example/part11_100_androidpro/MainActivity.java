package com.example.part11_100_androidpro;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView textLiveActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textLiveActivity = findViewById(R.id.textLifeActivity);
        if(savedInstanceState != null){
            textLiveActivity.setText(savedInstanceState.getString("textToBundle"));
        }
        Log.d("Life of activity", "onCreate");
        textLiveActivity.append("onCreate\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Life of activity", "onStart");
        textLiveActivity.append("onCreate\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Life of activity", "onRestart");
        textLiveActivity.append("onRestart\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Life of activity", "onPause");
        textLiveActivity.append("onPause\n");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Life of activity", "onResume");
        textLiveActivity.append("onResume\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        textLiveActivity.append("onStop\n");
        Log.d("Life of activity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Life of activity", "onDestroy");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        textLiveActivity.append("onSaveInstanceState()\n");
        outState.putString("textToBundle", textLiveActivity.getText().toString());
    }
}