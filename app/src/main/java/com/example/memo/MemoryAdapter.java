package com.example.memo;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.memo.data.MemoryData;

import java.util.ArrayList;

public class MemoryAdapter extends RecyclerView.Adapter<MemoryAdapter.ViewHolder> {

    Context context;
    ArrayList<MemoryData> memoryDataList;

    public MemoryAdapter(Context context, ArrayList<MemoryData> memoryDataList) {
        this.context = context;
        this.memoryDataList = memoryDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.memory_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MemoryData data = memoryDataList.get(position);
        holder.name.setText(data.getName());
        if(data.getLogo() != null)
            holder.image.setImageURI(data.getLogo());
        else
            holder.image.setImageResource(R.drawable.no_image);
        holder.itemView.setOnClickListener(view -> {
            Intent switchMemory = new Intent(context, MemoryActivity.class);
            switchMemory.putExtra("memoryPosition", position);
            switchMemory.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(switchMemory);
        });
    }



    @Override
    public int getItemCount() {
        return memoryDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private final ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.memory_text);
            image = itemView.findViewById(R.id.memory_image);
        }
    }
}
