package ucll.java.mobile.ucll_gip5_groep7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import ucll.java.mobile.ucll_gip5_groep7.Models.Video;

public class GalaryAdapter1 extends RecyclerView.Adapter<VideoViewHolder> {

    private List<Video> videoList;
    private Context context;
    private int index;

    public GalaryAdapter1(List<Video> videoList, Context context) {
        this.videoList = videoList;
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inlfate the layout
        context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View videoView = layoutInflater.inflate(R.layout.video_card, parent, false);

        VideoViewHolder viewHolder = new VideoViewHolder(videoView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int position) {

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

}
