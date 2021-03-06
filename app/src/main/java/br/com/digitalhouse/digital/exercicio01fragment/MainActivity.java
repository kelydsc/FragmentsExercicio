package br.com.digitalhouse.digital.exercicio01fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.digitalhouse.digital.exercicio01fragment.fragments.Fragment1;
import br.com.digitalhouse.digital.exercicio01fragment.fragments.Fragment2;

public class MainActivity extends AppCompatActivity {

    private Button btnFragment1;
    private Button btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnFragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFragment(new Fragment1());
            }
        });

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addFragment(new Fragment2());
            }
        });
    }

    private void addFragment(Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container2,fragment);
        transaction.addToBackStack("FRAGMENTS");
        transaction.commit();

    }


    private void initViews() {
        btnFragment1 = findViewById(R.id.button1);
        btnFragment2 = findViewById(R.id.button2);
    }
}
