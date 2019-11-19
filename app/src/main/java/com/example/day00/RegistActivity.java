package com.example.day00;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edname;
    private EditText edpwd;
    private EditText edpwds;
    private EditText day;
    private EditText show;
    /**
     * 注册
     */
    private Button btnno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        initView();
    }

    private void initView() {
        edname = (EditText) findViewById(R.id.edname);
        edpwd = (EditText) findViewById(R.id.edpwd);
        edpwds = (EditText) findViewById(R.id.edpwds);
        day = (EditText) findViewById(R.id.day);
        show = (EditText) findViewById(R.id.show);
        btnno = (Button) findViewById(R.id.btnno);
        btnno.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btnno:
                regist();
                break;
        }
    }

    private void regist() {
        String name = edname.getText().toString().trim();
        String pwd = edpwd.getText().toString().trim();
        String pwds = edpwds.getText().toString().trim();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd) || TextUtils.isEmpty(pwds)){
            Toast.makeText(this, "账号密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!pwd.equals(pwds)){
            Toast.makeText(this, "密码一致", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("name",name);
        intent.putExtra("pwd",pwd);
        setResult(2,intent);
        finish();

    }
}
