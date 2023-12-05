package com.example.examen20231205_carlosmanso.Handlers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen20231205_carlosmanso.R;

import java.util.List;

public class Count_adapter extends RecyclerView.Adapter<Count_adapter.ViewHolder> {

    List<Count_handler> nodes;

    public Count_adapter(List<Count_handler> nodes) {this.nodes = nodes;}

    @NonNull
    @Override
    public Count_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.count, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Count_adapter.ViewHolder holder, int position) {
        holder.bind(nodes.get(position));
    }

    @Override
    public int getItemCount() {
        return nodes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv;

        public ViewHolder(View v){
            super(v);
            this.tv = v.findViewById(R.id.count_node);

        }

        void bind (Count_handler ch){
            tv.setText(formatHours(ch.getCount()));
        }

        String formatHours(String s) {
            int t = Integer.parseInt(s);
            int m = 0;
            int h = 0;

            if (t > 59) {
                m = t / 60;
                t = t - m * 60;
                if (m > 59) {
                    h = m / 60;
                    m = t - m * 60;
                    t = Integer.parseInt(s) - (t * 60 * 60 + m * 60);
                }
            }
            return h + ":" + m + ":" + t;
        }
    }


}
