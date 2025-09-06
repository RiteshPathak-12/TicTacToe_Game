package com.example.tictactoegame;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView toastMass,toastMass2,toastMass3;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,Reset;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int flag=0;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        init();


    }

    @Override
    public void onBackPressed() {
        AlertDialog exitDilog=new AlertDialog.Builder(this).create();
        exitDilog.setTitle("Exit ?");
        exitDilog.setMessage("Do yo want to exit ?");
        exitDilog.setIcon(R.drawable.exit_to_app_24);
        exitDilog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        exitDilog.setButton(DialogInterface.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tostCreation_Continue();
                init();
            }
        });
        exitDilog.show();
    }

    private void init()
    {
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        Reset=findViewById(R.id.Reset);

    }


    public void check(View a)
    {
        count++;
        Button btnCurent=(Button) a;
        if (btnCurent.getText().toString().equals("")) {
            if (flag == 0) {
                btnCurent.setText("X");
                flag = 1;
            } else {
                btnCurent.setText("O");
                flag = 0;
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    tostCreation_b1();
                    Disable();


                } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                    tostCreation_b4();
                    Disable();



                } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                    tostCreation_b7();
                    Disable();

                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    tostCreation_b1();
                    Disable();


                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    tostCreation_b2();
                    Disable();

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    tostCreation_b3();
                    Disable();


                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    tostCreation_b1();
                    Disable();


                } else if (b3.equals(b5) && b5.equals(b7) && !b7.equals("")) {
                    tostCreation_b7();
                    Disable();

                } else if (count==9) {
                    tostCreation_draw();
                    Disable();

                }

            }
        }
    }
    public void Restart()
    {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");


        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);



        count=0;
        flag=0;


    }
    public void ResetGame(View b){

        AlertDialog alertDialog=new AlertDialog.Builder(this).create();

        alertDialog.setTitle("Restart");
        alertDialog.setMessage("Do you want to Re-start your game ");
        alertDialog.setIcon(R.drawable.restart_image);
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tostCreation_Restart();
                        Restart();
                    }
                });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        alertDialog.show();
    }

    private void tostCreation_b1(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation,(ViewGroup) findViewById(R.id.toastContainer));
        toast.setView(view);
        TextView toastMass=view.findViewById(R.id.toastMass);
        toastMass.setText("Winner "+b1);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void tostCreation_b4(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation,(ViewGroup) findViewById(R.id.toastContainer));
        toast.setView(view);
        TextView toastMass=view.findViewById(R.id.toastMass);
        toastMass.setText("Winner "+b4);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void tostCreation_b7(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation,(ViewGroup) findViewById(R.id.toastContainer));
        toast.setView(view);
        TextView toastMass=view.findViewById(R.id.toastMass);
        toastMass.setText("Winner "+b1);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void tostCreation_b2(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation,(ViewGroup) findViewById(R.id.toastContainer));
        toast.setView(view);
        TextView toastMass=view.findViewById(R.id.toastMass);
        toastMass.setText("Winner "+b2);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void tostCreation_b3(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation,(ViewGroup) findViewById(R.id.toastContainer));
        toast.setView(view);
        TextView toastMass=view.findViewById(R.id.toastMass);
        toastMass.setText("Winner "+b3);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void tostCreation_draw(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation3,(ViewGroup) findViewById(R.id.toastContainer3));
        toast.setView(view);
        TextView toastMass3=view.findViewById(R.id.toastMass3);
        toastMass3.setText("Match is Draw");
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void tostCreation_Restart(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation2,(ViewGroup) findViewById(R.id.toastContainer2));
        toast.setView(view);
        TextView toastMass2=view.findViewById(R.id.toastMass2);
        toastMass2.setText("Your game is restarted Now");
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void tostCreation_Continue(){
        Toast toast=new Toast(this);
        View view=getLayoutInflater().inflate(R.layout.toast_creation2,(ViewGroup) findViewById(R.id.toastContainer2));
        toast.setView(view);
        TextView toastMass2=view.findViewById(R.id.toastMass2);
        toastMass2.setText("Plese Continue your game");
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER,0,100);
        toast.show();
    }

    private void Disable(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }



}
