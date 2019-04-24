package com.example.herihomes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PropertyRecylerViewAdapter extends RecyclerView.Adapter<PropertyRecylerViewAdapter.ViewHolder> implements Filterable {
    List<JSONObject> properties;
    Context context;
    List<JSONObject> arrayListf;

    public PropertyRecylerViewAdapter(List<JSONObject> properties, Context context) {
        this.properties = properties;
        this.context = context;
        this.arrayListf = properties;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.property, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        JSONObject object = arrayListf.get(i);
        try {
            viewHolder.name.setText(object.getString("name"));
            viewHolder.address.setText(object.getString("address"));
            Glide.with(context).load(object.getString("imageUrl")).into(viewHolder.imageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return arrayListf.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    arrayListf = properties;
                } else {
                    List<JSONObject> filteredList = new ArrayList<>();
                    for (int i = 0; i < properties.size(); i++) {
                        JSONObject object = properties.get(i);
                        try {
                            if (object.getString("name").toLowerCase().contains(charString.toLowerCase()) | object.getString("address").toLowerCase().contains(charString.toLowerCase())) {
                                filteredList.add(object);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    arrayListf = filteredList;
                }


                FilterResults filterResults = new FilterResults();
                filterResults.values = arrayListf;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                arrayListf = (List<JSONObject>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, address;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);

        }
    }
}
