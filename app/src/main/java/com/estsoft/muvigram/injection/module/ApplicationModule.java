package com.estsoft.muvigram.injection.module;

import android.app.Application;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.estsoft.muvigram.data.remote.FeedService;
import com.estsoft.muvigram.data.remote.FindFriendService;
import com.estsoft.muvigram.data.remote.LoginTestService;
import com.estsoft.muvigram.data.remote.MusicSelectService;
import com.estsoft.muvigram.data.remote.NetworkTestService;
import com.estsoft.muvigram.data.remote.NotifyCommentService;
import com.estsoft.muvigram.data.remote.NotifyFollowService;
import com.estsoft.muvigram.data.remote.NotifyLikeService;
import com.estsoft.muvigram.data.remote.ProfileThumbnailService;
import com.estsoft.muvigram.data.remote.ProfileUserInfoService;
import com.estsoft.muvigram.data.remote.SearchMusicService;
import com.estsoft.muvigram.data.remote.SearchTagService;
import com.estsoft.muvigram.data.remote.SearchUserService;
import com.estsoft.muvigram.data.remote.TrendingSoundsService;
import com.estsoft.muvigram.data.remote.TrendingTagsService;
import com.estsoft.muvigram.data.remote.TrendingUsersService;
import com.estsoft.muvigram.injection.qualifier.ApplicationContext;
import com.estsoft.muvigram.model.NotifyFollow;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gangGongUi on 2016. 10. 9..
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    /** Constructor */
    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    /* System */
    @Provides
    public Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


    /* Explicit Functionality */
    @Provides
    @Singleton
    MediaPlayer provideMediaPlayer() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        return mediaPlayer;
    }

    /* Implicit Functionality */
    @Provides
    @Singleton
    NetworkTestService providesNetWorkTestService() {
        return new NetworkTestService();
    }

    @Provides
    @Singleton
    LoginTestService provideLoginService() {
        return LoginTestService.Creator.newLoginService();
    }

    @Provides
    @Singleton
    MusicSelectService provideMusicSelectService() {
        return MusicSelectService.Creator.newMusicSelectService();
    }

    @Provides
    @Singleton
    FindFriendService provideFindFriendService() {
        return FindFriendService.Creator.newFindFriendService();
    }

    @Provides
    @Singleton
    TrendingTagsService provideTrendingTagsService(){
        return TrendingTagsService.Creator.newTrendingTagsService();
    }

    @Provides
    @Singleton
    TrendingSoundsService provideTrendingSoundsService(){
        return TrendingSoundsService.Creator.newTredingSoundsService();
    }

    @Provides
    @Singleton
    TrendingUsersService provideTrendingUsersService(){
        return TrendingUsersService.Creator.newTrendingUserService();
    }

    @Provides
    @Singleton
    FeedService provideFeedService(){
        return FeedService.Creator.newFeedService();
    }

    @Provides
    SearchUserService provideSearchUserService(){
        return SearchUserService.Creator.newSearchUserService();
    }

    @Provides
    @Singleton
    SearchTagService provideSearchTagService(){
        return SearchTagService.Creator.newSearchTagService();
    }

    @Provides
    @Singleton
    SearchMusicService provideSearchMusicService(){
        return SearchMusicService.Creator.newSearchMusicService();
    }

    @Provides
    @Singleton
    NotifyCommentService provideNotifyCommnetSerivce(){
        return NotifyCommentService.Creator.newNotifyCommentService();
    }

    @Provides
    @Singleton
    NotifyFollowService provideNotifyFollowService(){
        return NotifyFollowService.Creator.newNotifyFollowService();
    }

    @Provides
    @Singleton
    NotifyLikeService provideNotifyLikeService(){
        return NotifyLikeService.Creator.newNotifyLikeService();
    }

    @Provides
    @Singleton
    ProfileUserInfoService provideProfileUserInfoService(){
        return ProfileUserInfoService.Creator.newProfileUserInfoService();
    }

    @Provides
    @Singleton
    ProfileThumbnailService provideProfileThumbnailService(){
        return ProfileThumbnailService.Creator.newProfileThumbnailService();
    }
}
