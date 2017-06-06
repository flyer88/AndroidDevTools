package com.zmsoft.devtools;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;
    String jsonData = "{\"hey\": \"guy\",\n" +
            "        \"anumber\": 243,\n" +
            "        \"anobject\": {\n" +
            "            \"whoa\": \"nuts\",\n" +
            "            \"anarray\": [1, 2, \"thr<h1>ee\"],\n" +
            "            \"more\":\"stuff\"\n" +
            "        },\n" +
            "        \"awesome\": true,\n" +
            "        \"bogus\": false,\n" +
            "        \"meaning\": null,\n" +
            "        \"japanese\":\"明日がある。\",\n" +
            "        \"link\": \"http://jsonview.com\",\n" +
            "        \"notLink\": \"http://jsonview.com is great\",\n" +
            "        \"multiline\": ['Much like me, you make your way forward,',\n" +
            "            'Walking with downturned eyes.',\n" +
            "            'Well, I too kept mine lowered.',\n" +
            "            'Passer-by, stop here, please.']" +
            "        }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLinearLayout = (LinearLayout) findViewById(R.id.root_ll);
        Button button = (Button) findViewById(R.id.show_data);
        final JsonView jsonView = new JsonView(MainActivity.this,mLinearLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonView.loadJson(jsonData);
            }
        });
    }
}
