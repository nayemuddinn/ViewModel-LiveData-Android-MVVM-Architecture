package com.example.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.text);
        button=findViewById(R.id.button);

        MainActivityViewModel model=new ViewModelProvider(this).get(MainActivityViewModel.class);
        MutableLiveData<String> randomNumber=model.getRandomNumber();
        Log.i(this.getClass().getSimpleName(),"Random number set");

        randomNumber.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.i(this.getClass().getSimpleName(),"UI updated");
                textView.setText(s);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model.createNumber();
            }
        });




    }

    @Override
    protected void onDestroy() {
        Log.i(this.getClass().getSimpleName(),"Called Destroy");
        super.onDestroy();
    }
}