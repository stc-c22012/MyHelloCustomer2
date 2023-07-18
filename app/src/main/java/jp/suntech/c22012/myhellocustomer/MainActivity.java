package jp.suntech.c22012.myhellocustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ボタン・オブジェクトの用意
        Button btClick = findViewById(R.id.btClick);
        //リスナ・オブジェクトの用意
        HelloListener listener = new HelloListener();
        //ボタンにリスナを設定
        btClick.setOnClickListener(listener);

        //住まいクリアボタンであるButtonオブジェクトを取得。
        Button btClear2 = findViewById(R.id.btPlaceClear);
        //お名前クリアボタンであるButtonオブジェクトを取得。
        Button btClear = findViewById(R.id.btNameClear);
        //お名前クリアボタンにリスナを設定
        btClear.setOnClickListener(listener);
        //住まいクリアボタンにリスナを設定
        btClear2.setOnClickListener(listener);
    }

    //ボタンをクリックした時のリスナクラス
    private class HelloListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //名前入力欄であるEditTextオブジェクトを取得。
            EditText input = findViewById(R.id.etName);
            //名前入力欄であるEditTextオブジェクトを取得。
            EditText input2 = findViewById(R.id.etplace);
            //メッセージを表示するTextViewオブジェクトを取得。
            TextView output = findViewById(R.id.tvOutput);

            //タップされた画面部品をidのR値を取得。
            int id = view.getId();
            //idのR値に応じて処理を分岐

            if(id==R.id.btClick){
                String inputStr = input.getText().toString();
                String input2Str = input2.getText().toString();
                String inputtext = input2Str + "にお住まいの" + inputStr + "さん、こんにちは！";

                Snackbar.make(view,inputtext, Snackbar.LENGTH_LONG).show();
            }
            if(id == R.id.btNameClear){
                input.setText("");
                output.setText("");
            }
            if(id == R.id.btPlaceClear) {
                input2.setText("");
                output.setText("");
            }
        }
    }

}