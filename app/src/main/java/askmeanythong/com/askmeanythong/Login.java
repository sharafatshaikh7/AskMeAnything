package askmeanythong.com.askmeanythong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    EditText edt_username,edt_pass;
    Button btn_submit;
    TextView txt_signup,txt_forgetpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edt_username=(EditText)findViewById(R.id.edt_username);
        edt_pass=(EditText)findViewById(R.id.edt_pass);
        btn_submit=(Button)findViewById(R.id.btn_login);
        txt_signup=(TextView)findViewById(R.id.signup);
        txt_forgetpass=(TextView)findViewById(R.id.forgetpass);


        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Login.this,Registration.class));
                finish();
            }
        });

        txt_forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Login.this,ForgetPassword.class));
                finish();
            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (edt_username.getText().toString().equals("") || edt_username.getText().toString().length() <=0) {
                    edt_username.setError("Enter Username");
                }else if(edt_pass.getText().toString().equals("") || edt_pass.getText().toString().length() <=0) {
                    edt_pass.setError("Enter Proper Password");
                }
                else
                {

                }
            }
        });
    }
}
