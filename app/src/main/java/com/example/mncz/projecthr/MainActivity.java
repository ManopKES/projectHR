package com.example.mncz.projecthr;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;

public class MainActivity extends AppCompatActivity {
    private Button start;
    private BluetoothAdapter bluetoothAdapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DescriptionActivity.class);
                startActivity(intent);
            }

        });

        init();
    }

    private void init() {
        if (bluetoothAdapter == null) {
            Toast.makeText(MainActivity.this, "null", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "not null", Toast.LENGTH_SHORT).show();
        }

        if (!bluetoothAdapter.isEnabled()) {
            intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 0);
            Toast.makeText(MainActivity.this, "Turned on", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Already on", Toast.LENGTH_SHORT).show();
        }
    }
}
