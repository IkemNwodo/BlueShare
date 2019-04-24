package nwodo.ikem.com.blueshare;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AppsAdapter extends RecyclerView.Adapter<AppsAdapter.AppsViewHolder> {

    private ArrayList<App> apps;

    public AppsAdapter(ArrayList<App> apps) {
        this.apps = apps;
    }

    @NonNull
    @Override
    public AppsAdapter.AppsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.apps_item, parent, false);
        return new AppsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AppsAdapter.AppsViewHolder holder, int position) {
        App app = apps.get(position);
        // Fill in your logic for binding the view.

        holder.appIcon.setImageDrawable(app.getIcon());
        holder.appName.setText(app.getName());
        holder.appSize.setText("0B");
    }

    @Override
    public int getItemCount() {
        if (apps == null) {
            return 0;
        }
        return apps.size();
    }

    class AppsViewHolder extends RecyclerView.ViewHolder {

        ImageView appIcon;
        TextView appName;
        TextView appSize;

        AppsViewHolder(View itemView) {
            super(itemView);

            appIcon = itemView.findViewById(R.id.app_icon);
            appName = itemView.findViewById(R.id.app_name);
            appSize = itemView.findViewById(R.id.app_size);
        }
    }
}