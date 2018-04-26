package com.app.dsr.simpplrassignment.network.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ErrorResponse implements Parcelable {
    public ErrorDetails error;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.error, 0);
    }

    public ErrorResponse() {
    }

    protected ErrorResponse(Parcel in) {
        this.error = in.readParcelable(ErrorDetails.class.getClassLoader());
    }

    public static final Creator<ErrorResponse> CREATOR = new Creator<ErrorResponse>() {
        public ErrorResponse createFromParcel(Parcel source) {
            return new ErrorResponse(source);
        }

        public ErrorResponse[] newArray(int size) {
            return new ErrorResponse[size];
        }
    };
}
