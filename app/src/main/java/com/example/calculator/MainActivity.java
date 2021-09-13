package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvKhaiBao;
    private String input,answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa textview
        tvKhaiBao = (TextView) findViewById(R.id.textKhaiBao);

    }
    // anh xa button
    public void ButtonClick(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data){
            case "AC":
                input ="";
                break;
            case "=" :
                Operation();
                answer = input;
                break;
            default:
                if(input == null ){
                    input = "";
                }
                if(data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/")){
                // in ket qua
                    Operation();
                }
                input += data;
        }
        tvKhaiBao.setText(input);
    }
    public void Operation(){
        if(input.split("\\+").length == 2){
            String phepTinh[] = input.split("\\+");
            try{
                double tong =  Double.parseDouble(phepTinh[0]) + Double.parseDouble(phepTinh[1]);
                input = tong + "";
            }catch (Exception e){
//cong
            }
        }
        if(input.split("\\-").length == 2) {
            String phepTinh[] = input.split("\\-");
            try {
                double hieu = Double.parseDouble(phepTinh[0]) - Double.parseDouble(phepTinh[1]);
                input = hieu + "";
            } catch (Exception e) {
//tru
            }
        }
        if(input.split("\\*").length == 2) {
            String phepTinh[] = input.split("\\*");
            try {
                double tich = Double.parseDouble(phepTinh[0]) * Double.parseDouble(phepTinh[1]);
                input = tich + "";
            } catch (Exception e) {
//nhan
            }
        }
        if(input.split("\\/").length == 2) {
            String phepTinh[] = input.split("\\/");
            try {
                double thuong = Double.parseDouble(phepTinh[0]) / Double.parseDouble(phepTinh[1]);
                input = thuong + "";
            } catch (Exception e) {
//chia
            }
        }
    }
}