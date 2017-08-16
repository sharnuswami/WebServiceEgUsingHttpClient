package com.example.hp_pc.asynctaskexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class AsyncTaskActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);





        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://api.androidhive.info/contacts/", new AsyncHttpResponseHandler() {


            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                /*System.out.println("responseBody ="+responseBody.toString());*/

                String responsestr = new String(responseBody);


                ContactRes contactRes = new Gson().fromJson(responsestr,ContactRes.class);


                ListView listView = (ListView) findViewById(R.id.contacts);

/*
                ContactRes contactRes = new Gson().fromJson(new String(responseBody),ContactRes.class);

*/


                System.out.println("Contact response is:" + contactRes.toString());
                listView.setAdapter(contactRes);


               /* new Gson().toJson(contactRes.contacts);*/

            }


            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

}