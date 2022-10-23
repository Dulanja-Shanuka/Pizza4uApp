package com.example.pizza4u;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class DashBoard extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[],s2[];
    int images[]={R.drawable.kfc__3_,R.drawable.kfc__3_,R.drawable.kfc__3_,
            R.drawable.kfc__3_,R.drawable.kfc__3_,R.drawable.kfc__3_,
            R.drawable.kfc__3_,R.drawable.kfc__3_, R.drawable.kfc__3_,
            R.drawable.kfc__3_,};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        getSupportActionBar().hide();


        recyclerView=findViewById(R.id.recycleView1);

        s1=getResources().getStringArray(R.array.Pizza_type);
        s2=getResources().getStringArray(R.array.description);

        MyAdapter myAdapter=new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}