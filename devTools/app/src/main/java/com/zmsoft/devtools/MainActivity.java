package com.zmsoft.devtools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout = (LinearLayout) findViewById(R.id.root_ll);
        JsonView jsonView = new JsonView(this,mLinearLayout);
    }
}
