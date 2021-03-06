package com.app.dsr.simpplrassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.Map;

/**
 * <a href="https://developer.spotify.com/web-api/object-model/#user-object-public">User object (public) model</a>
 */
public class UserPublic implements Parcelable {
    protected String display_name;
    protected Map<String, String> external_urls;
    protected Followers followers;
    protected String href;
    protected String id;
    protected List<Image> images;
    protected String type;
    protected String uri;

    public UserPublic() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.display_name);
        dest.writeMap(this.external_urls);
        dest.writeParcelable(this.followers, 0);
        dest.writeString(this.href);
        dest.writeString(this.id);
        dest.writeTypedList(images);
        dest.writeString(this.type);
        dest.writeString(this.uri);
    }

    protected UserPublic(Parcel in) {
        this.display_name = in.readString();
        this.external_urls = in.readHashMap(Map.class.getClassLoader());
        this.followers = in.readParcelable(Followers.class.getClassLoader());
        this.href = in.readString();
        this.id = in.readString();
        this.images = in.createTypedArrayList(Image.CREATOR);
        this.type = in.readString();
        this.uri = in.readString();
    }

    public static final Creator<UserPublic> CREATOR = new Creator<UserPublic>() {
        public UserPublic createFromParcel(Parcel source) {
            return new UserPublic(source);
        }

        public UserPublic[] newArray(int size) {
            return new UserPublic[size];
        }
    };

    public String getDisplay_name() {
        return display_name;
    }

    public Map<String, String> getExternal_urls() {
        return external_urls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    @Override
    public String toString() {
        return "UserPublic{" +
                "display_name='" + display_name + '\'' +
                ", external_urls=" + external_urls +
                ", followers=" + followers +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
