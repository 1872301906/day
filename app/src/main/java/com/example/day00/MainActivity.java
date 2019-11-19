package com.example.day00;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private EditText pwd;
    /**
     * 登录
     */
    private Button btnok;
    /**
     * 注册
     */
    private Button btnno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        pwd = (EditText) findViewById(R.id.pwd);
        btnok = (Button) findViewById(R.id.btnok);
        btnok.setOnClickListener(this);
        btnno = (Button) findViewById(R.id.btnno);
        btnno.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnok:
                break;
            case R.id.btnno:
                regist();
                break;
        }
    }

    private void regist() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
        == PackageManager.PERMISSION_GRANTED){
            //跳转
            startActivityForResult(new Intent(this,RegistActivity.class),1);
        }
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
            show("申请成功");
        }else {
            show("申请失败");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1 || resultCode==2){
            if (data !=null){
                String name1 = data.getStringExtra("name");
                String pwd1 = data.getStringExtra("pwd");

                name.setText(name1);
                pwd.setText(pwd1);
            }
        }
    }

    public void show(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}
