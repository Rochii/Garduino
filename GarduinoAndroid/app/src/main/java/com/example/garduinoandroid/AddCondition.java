package com.example.garduinoandroid;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class AddCondition extends AppCompatActivity implements View.OnClickListener{

    Button timeCondition;
    Data obj;
    Boolean informationBoolean;
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#bebebe")));
        ((AppCompatActivity) this).getSupportActionBar().setTitle("Add new condition");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_condition);

        timeCondition = (Button) findViewById(R.id.timeCondition);
        timeCondition.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            obj = (Data) getIntent().getExtras().getSerializable("object");
            informationBoolean = (Boolean) getIntent().getExtras().get("btnSettingsDPS");
        }

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.timeCondition:
                Intent intentTime = new Intent(this, TimeConditions.class);
                intentTime.putExtra("object", (Serializable) obj);
                intentTime.putExtra("btnSettingsDPS", informationBoolean);
                startActivity(intentTime);
                break;
            default:
                break;
        }
    }
}
