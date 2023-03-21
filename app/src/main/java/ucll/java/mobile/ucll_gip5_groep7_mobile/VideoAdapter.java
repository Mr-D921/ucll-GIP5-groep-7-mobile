package ucll.java.mobile.ucll_gip5_groep7_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ucll.java.mobile.ucll_gip5_groep7_mobile.Models.Video;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder> {

    private ArrayList<Video> videoList;

    public VideoAdapter(ArrayList<Video> videoList) {
        this.videoList = videoList;
    }


    @NonNull
    @Override
    public VideoAdapter.VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_list, parent, false);
        return new VideoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoViewHolder holder, int position) {
        String name = videoList.get(position).getName();
        String id = String.valueOf(videoList.get(position).getId());

        holder.videoId.setText(id);
        holder.videoTitle.setText(name);

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        private TextView videoTitle;
        private TextView videoId;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);

            videoId = (TextView) itemView.findViewById(R.id.videoId);
            videoTitle = (TextView) itemView.findViewById(R.id.videoTitle);
        }


    }
}
