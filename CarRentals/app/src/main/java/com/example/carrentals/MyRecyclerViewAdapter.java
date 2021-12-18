package com.example.carrentals;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    List<ViewItemModel> carList;
    public OnCarListener carListener;
    public MyRecyclerViewAdapter(List<ViewItemModel> carList, OnCarListener carListener) {
        this.carList = carList;
        this.carListener = carListener;
    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        MyRecyclerViewAdapter.ViewHolder viewHolder = new MyRecyclerViewAdapter.ViewHolder(view, carListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {
        int imageId = carList.get(position).getImageView();
        String headingName = carList.get(position).getHeading();
        String detailsName = carList.get(position).getDetails();
        String rating_km_driven_Name = carList.get(position).getRating_km_driven();
        String priceName = carList.get(position).getPrice();
        int divider2Id = carList.get(position).getDivider2();
        int divider3Id = carList.get(position).getDivider3();
        holder.setData(imageId, headingName, detailsName, rating_km_driven_Name, priceName, divider2Id, divider3Id);
    }

    @Override
    public int getItemCount() {
        return carList.size();
    }
    public interface OnCarListener{
        void onCarClick(int position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView carPhoto;
        private TextView heading;
        private TextView details;
        private TextView ratingKmDriven;
        private TextView price;
        private View divider2;
        private View divider3;
        public OnCarListener onCarListener;

        public ViewHolder(@NonNull View itemView, OnCarListener onCarListener) {
            super(itemView);
            carPhoto = itemView.findViewById(R.id.photo);
            heading = itemView.findViewById(R.id.heading);
            details = itemView.findViewById(R.id.details);
            ratingKmDriven = itemView.findViewById(R.id.rating_km_driven);
            price = itemView.findViewById(R.id.price);
            divider2 = itemView.findViewById(R.id.divider2);
            divider3 = itemView.findViewById(R.id.divider3);
            this.onCarListener = onCarListener;
            itemView.setOnClickListener(v -> {
            onCarListener.onCarClick(getAdapterPosition());
            });
        }

        public void setData(int imageId, String headingName, String detailsName, String rating_km_driven_name,
                            String priceName, int divider2Id, int divider3Id) {
            carPhoto.setImageResource(imageId);
            heading.setText(headingName);
            details.setText(detailsName);
            ratingKmDriven.setText(rating_km_driven_name);
            price.setText(priceName);
            divider2.setId(divider2Id);
            divider3.setId(divider3Id);
        }
    }
}
