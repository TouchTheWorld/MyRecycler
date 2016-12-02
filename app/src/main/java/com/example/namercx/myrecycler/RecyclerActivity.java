package com.example.namercx.myrecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMyAdapter = new MyAdapter(getData());
        mRecyclerView.setAdapter(mMyAdapter);
    }

    private ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        String name = "studnet";
        int number = 20160000;
        for (int i=0;i<50;i++){
            data.add(name + i + "----"+ (number + i));
        }

        return data;
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private TextView mIdTextView;
        public ViewHolder(View iteamView){
            super(iteamView);
            mIdTextView = (TextView) iteamView;
        }
    }
    private class MyAdapter extends  RecyclerView.Adapter<ViewHolder>{
        private ArrayList<String> data;
        public MyAdapter(ArrayList<String> data){
            this.data = data;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(
                    android.R.layout.simple_list_item_1,parent,false);
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mIdTextView.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}
