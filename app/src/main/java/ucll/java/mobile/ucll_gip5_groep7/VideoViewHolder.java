package ucll.java.mobile.ucll_gip5_groep7;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class VideoViewHolder extends RecyclerView.ViewHolder {

    private TextView videoTitle;
    private TextView personName;
    private TextView viewsCount;
    private TextView uploadDate;
    private TextView videoDuration;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        videoTitle = itemView.findViewById(R.id.videoTitle);
        personName = itemView.findViewById(R.id.personName);
        viewsCount = itemView.findViewById(R.id.viewsCount);
        uploadDate = itemView.findViewById(R.id.viewsCount);
        videoDuration = itemView.findViewById(R.id.videoDuration);
    }
}
