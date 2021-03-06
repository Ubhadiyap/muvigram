package com.estsoft.muvigram.ui.musicselect.local;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.estsoft.muvigram.R;
import com.estsoft.muvigram.injection.PerNestedFragment;
import com.estsoft.muvigram.model.Music;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jaylim on 11/2/2016.
 */

@PerNestedFragment
public class MusicSelectLocalListAdapter extends RecyclerView.Adapter<MusicSelectLocalListAdapter.MusicViewHolder> {

    private List<Music> mMusics;

    @Inject
    public MusicSelectLocalListAdapter() {
        mMusics = new ArrayList<>();
    }

    public void setMusics(List<Music> musics) {
        mMusics = musics;
    }

    @Override
    public MusicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_musicselect_local_list_item, parent, false);
        return new MusicViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MusicViewHolder holder, int position) {
        Music music = mMusics.get(position);
        holder.mMusicTitle.setText(music.title());
        holder.mMusicArtist.setText(music.artist());
    }

    @Override
    public int getItemCount() {
        return mMusics.size();
    }

    class MusicViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.musicselect_local_list_item_music_play) ImageView mPlayButton;
        @BindView(R.id.musicselect_local_list_item_music_title) TextView mMusicTitle;
        @BindView(R.id.musicselect_local_list_item_music_artist) TextView mMusicArtist;

        public MusicViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
