package com.example.softheart.englishnumbers;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.softheart.englishnumbers.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
ActivityWelcomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_welcome);
        binding.startBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_bt:
                Intent intent=new Intent(getApplicationContext(),SongsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
