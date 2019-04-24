package nwodo.ikem.com.blueshare;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class App {

    @NonNull
    private Drawable icon;
    @NonNull
    private String name;
    @Nullable
    private int size;

    App(){
    }

    @NonNull
    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(@NonNull Drawable icon) {
        this.icon = icon;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @Nullable
    public int getSize() {
        return size;
    }

    public void setSize(@Nullable int size) {
        this.size = size;
    }
}


