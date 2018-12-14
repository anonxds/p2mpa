package com.example.user.p2mpa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  /*  private Button mNextButton;
    private Button mPreviousButton;
    private TextView mStudentTextView;
    */
    private Button mNextButton;
    private Button mPreviousButton;
    private TextView mStudentTextView;


    //creacion de constante

    private static final String TAG="etiqueta";
    private static final String KEY_INDEX ="indice";



    //    //creacion de arrreglo

    Student [] mStudent=new Student[]{
            new Student(111,"cARlos",100),
            new Student(112,"ahhh",1)

    };
    int [] numeos=new int [] {

    };
     private int mCurrentIndex=0;

     //una funcion
       private void updateStudent(){
           mStudentTextView.setText(
                   mStudent[mCurrentIndex].getNoControl()+"\n"+
                           mStudent[mCurrentIndex].getName()+"\n"+
                           mStudent[mCurrentIndex].getScore()
           );
       }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mStudentTextView=(TextView)findViewById(R.id.Student_Textview);
       mNextButton=(Button)findViewById(R.id.Next_button);
       mPreviousButton=(Button)findViewById(R.id.Previous_button);

       //creacion de eventos
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mCurrentIndex++;
//                if (mCurrentIndex >= mStudent.length) {
//                    mCurrentIndex=0;
//                }
                mCurrentIndex=(mCurrentIndex+1)% (mStudent.length);
                Log.d(TAG, "el balor del indice es : " + mCurrentIndex);

              updateStudent();
            }
        });
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mCurrentIndex++;
//                if (mCurrentIndex >= mStudent.length) {
//                    mCurrentIndex=0;
//                }
                mCurrentIndex=(mCurrentIndex+mStudent.length-1)% (mStudent.length);
                updateStudent();
            }
        });

        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,
                    0 );
        }
        updateStudent();
        Log.d(TAG,"onCreate() llamado");

   updateStudent();

   Log.d(TAG,"onCreate llamado");




    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
           super.onSaveInstanceState(savedInstanceState);
           Log.d(TAG, "onSaveInstanceState() llamado");
           savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }

    @Override
    protected void onStart(){
           super.onStart();
           Log.d(TAG,"onStart() llamado");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume() llamado");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause() llamado");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy() llamado");
    }

}
