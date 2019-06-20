package com.aacm13.bluetoothchat;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button listen, listDevices;
    ImageView send;
    ListView listView;
    TextView status, msg;
    EditText writemsg;

    BluetoothAdapter bluetoothAdapter;
    BluetoothDevice[] btArray;

    static final int STATE_LISTENING = 1;
    static final int STATE_CONNECTING = 2;
    static final int STATE_CONNECTED = 3;
    static final int STATE_CONNECTION_FAILED= 4;
    static final int STATE_MESSAGE_RECIEVED = 5;

    int REQUEST_ENABLE_BLUETOOTH =1 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewByIdes();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (!bluetoothAdapter.isEnabled()){
            Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableIntent, REQUEST_ENABLE_BLUETOOTH);
        }

        implementListeners();
    }

    private void implementListeners(){

    }

    private void findViewByIdes(){
        listen = (Button) findViewById(R.id.listen);
        send = (ImageView) findViewById(R.id.send);
        listView=(ListView) findViewById(R.id.listview);
        msg = (TextView) findViewById(R.id.msg);
        status=(TextView) findViewById(R.id.status);
        writemsg=(EditText) findViewById(R.id.writemsg);
        listDevices = (Button) findViewById(R.id.listDevices);
    }
}
