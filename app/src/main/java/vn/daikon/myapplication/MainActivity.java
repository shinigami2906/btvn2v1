package vn.daikon.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import vn.daikon.myapplication.repository.UserRepo;

public class MainActivity extends AppCompatActivity {
    EditText et_msv,et_ten;
    TextView tv_info;
    Button bt_tao;
    UserRepo userRepo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_msv = (EditText) findViewById(R.id.et_msv);
        et_ten = (EditText) findViewById(R.id.et_ten);
        tv_info = (TextView) findViewById(R.id.tv_info);
        bt_tao = (Button) findViewById(R.id.bt_tao);
        userRepo = new UserRepo(getSharedPreferences("daumanhtuan",MODE_PRIVATE));
        Pair<String,String> info = userRepo.getUser();
        updateInfo(info.first, info.second);
    }
    public void updateInfo(String name, String msv){
        tv_info.setText("Xinchao: "+ name +" + "+msv);
    }
    public void onClick(View view){
        String name = et_ten.getText().toString();
        String msv = et_msv.getText().toString();
        if (name != "" && msv != ""){
            userRepo.updateUser(name,msv);
            updateInfo(name,msv);
        }
    }
}
