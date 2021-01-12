package com.example.laborrequestingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class wrokerHome extends AppCompatActivity {

    Jobs[] versions = {
            new Jobs("John", "Technician", "Worker in a field of technology who is proficient in the relevant skill and technique",R.drawable.profile1),
            new Jobs("Ruby", "Cleaners", "Cleaning the house and yard",R.drawable.ruby),
            new Jobs("Hansel", "Electricians", "Fixing tv, tv unable to turn on",R.drawable.hansel),
            new Jobs("Max", "Cleaners", "Cleaning the house and yard",R.drawable.ghozi),
            new Jobs("Annisa", "Cleaners", "Cleaning the house and yard",R.drawable.anisa),
            new Jobs("Ubai", "Electricians", "Fixing tv, tv unable to turn on",R.drawable.ubai),
            new Jobs("Ghozi", "Technician", "Worker in a field of technology who is proficient in the relevant skill and technique",R.drawable.profile1),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wroker_home);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ImageView profile = findViewById(R.id.profile);

        profile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(wrokerHome.this, workerProfile.class);
                startActivity(intent);
            }
        });

        MyAdapter myAdapter = new MyAdapter();
        myAdapter.addElements(versions);
        recyclerView.setAdapter(myAdapter);

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        public void addElements(Jobs[] versions) {
            elements.clear();
            elements.addAll(Arrays.asList(versions));
            notifyDataSetChanged();
        }

        ArrayList<Jobs> elements = new ArrayList<Jobs>();
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View rowView = getLayoutInflater().inflate(R.layout.row, parent, false);
            return new MyViewHolder(rowView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.textView.setText(elements.get(position).getName());
            holder.textView2.setText(elements.get(position).getJob_description());
            holder.textView3.setText(elements.get(position).getDescription());
            holder.imageView.setImageResource(elements.get(position).getIcon());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(wrokerHome.this, elements.get(position).getName()+" choosed.", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return elements.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;
            public TextView textView2;
            public TextView textView3;
            public ImageView imageView;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.name);
                textView2 = itemView.findViewById(R.id.jobdesc);
                textView3 = itemView.findViewById(R.id.desc);
                imageView = itemView.findViewById(R.id.imageView);

            }
        }
    }
}