package com.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//PeopleAdapter is temporary data storage thats y its nt activity bt class.its fr transferring the data of books

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder> {
    static bookdetails[] details;
    PeopleAdapter(bookdetails[] details)

    {
        this.details=details;
    }

    public static class PeopleAdapterViewHolder extends RecyclerView.ViewHolder
    {
        TextView fname,lname,positionn,bookname;
        ImageView small_dp;
        Context mContext;

        public PeopleAdapterViewHolder(final View itemView)
        {
            super(itemView);
            mContext=itemView.getContext();
            fname=itemView.findViewById(R.id.first);
            lname=itemView.findViewById(R.id.last);
            positionn=itemView.findViewById(R.id.pos);
            small_dp=itemView.findViewById(R.id.bg);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(itemView.getContext(),profiles.class);
                    i.putExtra("obj",details).putExtra("pos",getAdapterPosition());
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }

    @NonNull
    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_layout, parent, false);
        return new PeopleAdapterViewHolder(view);
    }

    public void onBindViewHolder(@NonNull PeopleAdapterViewHolder holder,int position)
    {
        holder.fname.setText(details[position].firstName);
        holder.lname.setText(details[position].lastName);
        holder.positionn.setText(details[position].Genre);

        int resID=holder.mContext.getResources().getIdentifier(details[position].imageName,"mipmap",holder.mContext.getPackageName());
        holder.small_dp.setImageBitmap(BitmapFactory.decodeResource(holder.mContext.getResources(),resID));
    }

    @Override
    public int getItemCount()
    {

        return details.length;
    }
}
