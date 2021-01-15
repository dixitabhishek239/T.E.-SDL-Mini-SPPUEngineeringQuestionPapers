package com.example.sppuquestionpapers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PaperDetails extends AppCompatActivity {

    String stringPath = "";
    List<ViewModel> viewModelList;
    DatabaseReference dataBaseReference;
    MyAdapter adapter;
    RecyclerView rView;
    int clicked=0;
    String subName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // to make action bar disappear.
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_paper_details);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rView = (RecyclerView) findViewById(R.id.recView);
        rView.setLayoutManager(new LinearLayoutManager(this));
        viewModelList = new ArrayList<>();
        Intent intent = getIntent();
        //adapter.notifyDataSetChanged();

        if (intent.hasExtra("sub0")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub0");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);


        }
        else if (intent.hasExtra("sub1")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub1");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub2")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub2");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub3")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub3");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub4")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub4");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub5")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub5");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub6")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub6");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub7")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub7");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub8")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub8");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub9")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub9");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub10")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub10");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub11")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub11");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub12")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub12");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub13")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub13");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else if (intent.hasExtra("sub14")) {
            // Clear the List. . .( viewModelList.clear() )
            stringPath = intent.getStringExtra("sub14");
            getFireBaseList(stringPath);
            getDataFromFireBase(stringPath);

        }
        else
        {
            Toast.makeText(getApplicationContext(),"Loading...",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    private void getDataFromFireBase( String paperLink ){
        FirebaseRecyclerOptions<ViewModel> options =
                new FirebaseRecyclerOptions.Builder<ViewModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child(paperLink), ViewModel.class)
                        .build();

        adapter = new MyAdapter(options, this, viewModelList);
        rView.setAdapter(adapter);
    }

    private void getFireBaseList( String firebaseList ){
        viewModelList.clear();
        dataBaseReference = FirebaseDatabase.getInstance().getReference(firebaseList);

        dataBaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    ViewModel viewModel = postSnapshot.getValue(ViewModel.class);
//                    ListPDF ListPdf = postSnapshot.getValue(ListPDF.class);
                    viewModelList.add(viewModel);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        adapter.notifyDataSetChanged();
        rView.setAdapter(null);
    }
}