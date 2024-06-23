package com.example.s2part2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecycelerViewActivity extends AppCompatActivity {

    RecyclerView recycelerView;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyceler_view);

        recycelerView = findViewById(R.id.recycelerView);

        hashMap = new HashMap<>();
        hashMap.put("video_id", "scznDjNLXzw");
        hashMap.put("title", "Hiya Zole হিয়া জ্বলে ");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id", "scznDjNLXzw");
        hashMap.put("title", "Hiya Zole হিয়া জ্বলে ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("video_id", "scznDjNLXzw");
        hashMap.put("title", "Hiya Zole হিয়া জ্বলে ");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("video_id", "scznDjNLXzw");
        hashMap.put("title", "Hiya Zole হিয়া জ্বলে ");
        arrayList.add(hashMap);



        MyAdaptar myAdaptar = new MyAdaptar();
        recycelerView.setAdapter(myAdaptar);
        recycelerView.setLayoutManager(new LinearLayoutManager(this));



    }

    //==============================================================


    private class MyAdaptar extends RecyclerView.Adapter<MyAdaptar.myViewHolder>{

        private  class myViewHolder extends RecyclerView.ViewHolder{
            TextView tvRecycel;

            public myViewHolder(@NonNull View itemView) {
                super(itemView);

                tvRecycel = itemView.findViewById(R.id.tvRecycel);
            }
        }

        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.recycel_item, parent, false);

            return new myViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
            hashMap = arrayList.get(position);
            String video_id = hashMap.get("video_id");
            String title = hashMap.get("title");

            holder.tvRecycel.setText(video_id +" " +  title);


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

    }

    // ======================================================

}