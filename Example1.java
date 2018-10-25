package com.amrhal.rx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class Example1 extends AppCompatActivity {

    String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example1);
        
        Test1();


    }

    private void Test1() {

        String[] Student = {"Amr","Ahmed","mohamed",};
        List<String> Students = new ArrayList<>();
        Students.add("amr");
        Students.add("ahmed");
        Students.add("mohamed");


        Observable<List<String>> sourceObservable = Observable.just(Students); //just operator

        Observer observer = new Observer< List<String> >() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e(TAG, "onSubscribe: "+ d.toString());
            }

            @Override
            public void onNext(List<String> strings) {
                Log.e(TAG, "onNext: s="+ strings.get(1));
            }
            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: "+e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete: ");

            }
        };
        sourceObservable.subscribe(observer); // bind observable with observer
    }
}
