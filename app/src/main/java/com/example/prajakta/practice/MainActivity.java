package com.example.prajakta.practice;

import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    TextView disp;
    static int result=0;
    private int NumberBf;
    private String firstOperator = "";
    boolean isOperation=false;
    public ButtonClickListener btnClick = new ButtonClickListener();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        disp=(TextView)findViewById(R.id.textView);
        disp.setText("");

        int idList[]={R.id.button,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,
                R.id.button8,R.id.button9,R.id.button10,R.id.button11,R.id.button12,R.id.button13,R.id.button14
        };
        for(int id:idList){
            View v=(View)findViewById(id);
            v.setOnClickListener(btnClick);
        }
    }

    public void mMath(String op){

        NumberBf = Integer.parseInt(disp.getText().toString());// save the screen
        mResult();
        if(op.equals("=")) {
            NumberBf = 0;
            result = 0;
            firstOperator="";
        }


        //NumberBf=Integer.parseInt(disp.getText().toString()) ;// save the screen
        //disp.setText("");

        //operationToDo=op; // save the operation
        //disp.setText("0");// clear the screen
    }

public void getKeyboard(String numb){
    String ScrCurrent= disp.getText().toString();

    if(ScrCurrent.equals("0")) {
        ScrCurrent="";
    }

        ScrCurrent += numb;
        disp.setText(ScrCurrent);

}
    public void mResult(){
        if(firstOperator.equals("+") || firstOperator.equals("")){
            result += NumberBf;
        }
        if(firstOperator.equals("-")){
                result =result - NumberBf;
        }
        disp.setText(String.valueOf(result));
    }
// new class ButtonClickListener
    private class ButtonClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v){
        //check

            switch (v.getId()) {
                case R.id.button13: //clear screen
                    result = 0;
                    disp.setText("");
                    NumberBf = 0;
                    firstOperator = "";
                    break;
                case R.id.button4: // plus
                    mMath("+");
                    firstOperator = "+";
                    isOperation = true;
                    break;
                case R.id.button10:
                    mMath("-");
                    firstOperator = "-";
                    isOperation = true;
                    // mResult();
                    break;
                case R.id.button14://equals
                    if (isOperation) {
                        break;
                    }
                    mMath("=");

                    break;
                default:
                    String numb = ((Button) v).getText().toString();
                    if (isOperation) { // isoperator means you have a operator and then a number.
                        disp.setText(""); // set screen to blank to show next number
                        isOperation = false;
                    }

                    getKeyboard(numb);
                    break;
            }

    }

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
