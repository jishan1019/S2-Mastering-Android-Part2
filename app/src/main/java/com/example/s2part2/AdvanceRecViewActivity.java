package com.example.s2part2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class AdvanceRecViewActivity extends AppCompatActivity {
    RecyclerView recycelerView;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_rec_view);

        recycelerView = findViewById(R.id.advanceRwcView);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookTitle", "Zero To Hero");
        hashMap.put("bookAuther", "jishn Hossain");
        hashMap.put("bookImage", "https://i.ibb.co/XS5ppxz/image.png");
        hashMap.put("booklink", "https://github.com/jishan1019");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookTitle", "Zero To Hero");
        hashMap.put("bookAuther", "jishn Hossain");
        hashMap.put("bookImage", "https://i.ibb.co/XS5ppxz/image.png");
        hashMap.put("booklink", "https://github.com/jishan1019");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "VIDEO");
        hashMap.put("videoTitle", "Jhoom By miner");
        hashMap.put("videoId", "scznDjNLXzw");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookTitle", "Zero To Hero");
        hashMap.put("bookAuther", "jishn Hossain");
        hashMap.put("bookImage", "https://i.ibb.co/XS5ppxz/image.png");
        hashMap.put("booklink", "https://github.com/jishan1019");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "VIDEO");
        hashMap.put("videoTitle", "Jhoom By miner");
        hashMap.put("videoId", "scznDjNLXzw");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "VIDEO");
        hashMap.put("videoTitle", "Jhoom By miner");
        hashMap.put("videoId", "scznDjNLXzw");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("itemType", "BOOK");
        hashMap.put("bookTitle", "Zero To Hero");
        hashMap.put("bookAuther", "jishn Hossain");
        hashMap.put("bookImage", "https://i.ibb.co/XS5ppxz/image.png");
        hashMap.put("booklink", "https://github.com/jishan1019");
        arrayList.add(hashMap);



        XAdaptar xAdaptar = new XAdaptar();
        recycelerView.setAdapter(xAdaptar);
        recycelerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //======================================================


    private class XAdaptar extends  RecyclerView.Adapter{

        int BOOK_ITEM = 0;
        int VIDEO_ITEM = 1;

        private class videViewHolder extends RecyclerView.ViewHolder{

            ImageView tvVideoImg;
            TextView tvVideoTitle;

            public videViewHolder(@NonNull View itemView) {
                super(itemView);

                tvVideoImg = itemView.findViewById(R.id.tvVideoImg);
                tvVideoTitle = itemView.findViewById(R.id.tvVideoTitle);
            }
        }

        private class bookViewHolder extends RecyclerView.ViewHolder{

            ImageView tvBookImg;
            TextView tvBookTitle,tvBookAuther;
            Button btnBookBuy;


            public bookViewHolder(@NonNull View itemView) {
                super(itemView);

                tvBookImg = itemView.findViewById(R.id.tvBookImg);
                tvBookTitle = itemView.findViewById(R.id.tvBookTitle);
                tvBookAuther = itemView.findViewById(R.id.tvBookAuther);
                btnBookBuy = itemView.findViewById(R.id.btnBookBuy);

            }
        }



        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();

            if(viewType == BOOK_ITEM){

                View myView = inflater.inflate(R.layout.adv_rec_book_item,parent,false);
                return new bookViewHolder(myView);

            }else{
                View myView = inflater.inflate(R.layout.adv_rec_video_item,parent,false);
                return new videViewHolder(myView);
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if(getItemViewType(position) == BOOK_ITEM){

                bookViewHolder myHolder = (bookViewHolder) holder;
                hashMap = arrayList.get(position);

                String bookTitle = hashMap.get("bookTitle");
                String bookAuther =  hashMap.get("bookAuther");
                String bookImage = hashMap.get("bookImage");
                String booklink =  hashMap.get("booklink");

                myHolder.tvBookTitle.setText(bookTitle);
                myHolder.tvBookAuther.setText(bookAuther);
               myHolder.btnBookBuy.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Toast.makeText(AdvanceRecViewActivity.this, "This is book", Toast.LENGTH_SHORT).show();
                   }
               });


            }else if(getItemViewType(position) == VIDEO_ITEM){

                videViewHolder myHolder = (videViewHolder) holder;
                hashMap = arrayList.get(position);
                String videoTitle = hashMap.get("videoTitle");
                String videoId =  hashMap.get("videoId");

                myHolder.tvVideoTitle.setText(videoTitle);

            }

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        @Override
        public int getItemViewType(int position) {

            hashMap = arrayList.get(position);
            String itemType = hashMap.get("itemType");


            if(itemType.contains("BOOK")){
                return BOOK_ITEM;
            }else{
                return VIDEO_ITEM;
            }
        }
    }


    //=========================================================
}