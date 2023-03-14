package com.example.tugas_caesar_cipher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void EncryptCcBtn(View view) {
        EditText input_txt = (EditText) findViewById(R.id.input_txt);
        Editable x = input_txt.getText();
        EditText cipher_txt = (EditText) findViewById(R.id.cipher_txt);
        cipher_txt.setText(EncryptionCc(x));
        EditText plain_txt = (EditText) findViewById(R.id.plain_txt);
        cipher_txt.setShowSoftInputOnFocus(false);
        plain_txt.setShowSoftInputOnFocus(false);
        plain_txt.setText("");
    }

    public void DecryptCcBtn(View view) {
        EditText input_txt = (EditText) findViewById(R.id.input_txt);
        Editable y = input_txt.getText();
        EditText plain_txt = (EditText) findViewById(R.id.plain_txt);
        plain_txt.setText(DecryptionCc(y));
        EditText cipher_txt = (EditText) findViewById(R.id.cipher_txt);
        cipher_txt.setShowSoftInputOnFocus(false);
        plain_txt.setShowSoftInputOnFocus(false);
        cipher_txt.setText("");
    }

    public void ClearField(View view) {
        EditText input_txt = (EditText) findViewById(R.id.input_txt);
        input_txt.setText("");
        EditText key_txt = (EditText) findViewById(R.id.key_txt);
        key_txt.setText("");
        EditText cipher_txt = (EditText) findViewById(R.id.cipher_txt);
        cipher_txt.setText("");
        EditText plain_txt = (EditText) findViewById(R.id.plain_txt);
        plain_txt.setText("");
        input_txt.requestFocus();
    }

    String EncryptionCc(Editable plain){
        EditText n = (EditText) findViewById(R.id.key_txt);
        int kunci = Integer.parseInt(n.getText().toString());
        String  temp = "";

        for(int i = 0 ; i < plain.length() ; i++){

            if(plain.charAt(i) == ' ')
            {
                temp += ' ';
            }
            else if (plain.charAt(i) + kunci >'z')
            {
                temp += ((char)(plain.charAt(i) - ( 26 - kunci )));
            }
            else
                temp += ((char)(plain.charAt(i) + kunci ));
        }
        return temp;
    }
    String DecryptionCc(Editable cipher){
        EditText n = (EditText) findViewById(R.id.key_txt);
        int kunci = Integer.parseInt(n.getText().toString());
        String  temp = "";

        for(int i = 0;i  < cipher.length(); i++){

            if(cipher.charAt(i) == ' ')
            {
                temp += ' ';
            }
            else if (cipher.charAt(i)- kunci <'a')
            {
                temp += ((char)(cipher.charAt(i) - ( kunci - 26)));
            }
            else
                temp += ((char)(cipher.charAt(i) - kunci ));
        }
        return temp;
    }
}