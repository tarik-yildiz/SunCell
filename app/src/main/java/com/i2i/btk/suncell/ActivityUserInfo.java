package com.i2i.btk.suncell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityUserInfo extends AppCompatActivity {
    private RecyclerView recyclerViewPackets;
    private UserPacketsAdapter userPacketsAdapter;
    RecyclerView.LayoutManager  layoutManager;
    private List<UserPacketModel> userPacketList;
    private ProgressBar progressBar;
    private TextView progressText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initComponents();
        fullScreen();
    }
    private void initComponents() {
        userPacketList=new ArrayList<>();
        userPacketList.add(new UserPacketModel("DATA",1000,250));
        userPacketList.add(new UserPacketModel("VOICE",1000,100));
        userPacketList.add(new UserPacketModel("SMS",1000,453));
        layoutManager=new LinearLayoutManager(this);
        recyclerViewPackets=findViewById(R.id.recylerViewPackets);
        recyclerViewPackets.setLayoutManager(layoutManager);
        userPacketsAdapter=new UserPacketsAdapter(this,userPacketList);
        recyclerViewPackets.setAdapter(userPacketsAdapter);
    }
    private void fullScreen(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
}