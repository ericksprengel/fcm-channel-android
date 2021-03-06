package io.fcmchannel.sdk.core.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MessageMetadata implements Parcelable {

    public MessageMetadata() {
    }

    @SerializedName("url_buttons")
    private List<UrlButton> urlButtons;
    @SerializedName("quick_replies")
    private List<String> quickReplies;

    protected MessageMetadata(Parcel in) {
        in.readList(urlButtons, UrlButton.class.getClassLoader());
        in.readStringList(quickReplies);
    }

    public static final Creator<MessageMetadata> CREATOR = new Creator<MessageMetadata>() {
        @Override
        public MessageMetadata createFromParcel(Parcel in) {
            return new MessageMetadata(in);
        }

        @Override
        public MessageMetadata[] newArray(int size) {
            return new MessageMetadata[size];
        }
    };

    public List<UrlButton> getUrlButtons() {
        return urlButtons;
    }

    public void setUrlButtons(List<UrlButton> urlButtons) {
        this.urlButtons = urlButtons;
    }

    public List<String> getQuickReplies() {
        return quickReplies;
    }

    public void setQuickReply(List<String> quickReplies) {
        this.quickReplies = quickReplies;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeList(urlButtons);
        parcel.writeStringList(quickReplies);
    }
}
