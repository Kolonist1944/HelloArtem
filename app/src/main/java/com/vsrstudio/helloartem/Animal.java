package com.vsrstudio.helloartem;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.ByteArrayOutputStream;

public class Animal implements Parcelable {
    public String name;
    public int weight;
    public Drawable picture;

    public Animal(String name, int weight, Drawable picture) {
        this.name = name;
        this.weight = weight;
        this.picture = picture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(name);
        destination.writeInt(weight);

        Bitmap bitmap = ((BitmapDrawable) picture).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] pictureData = stream.toByteArray();
        destination.writeByteArray(pictureData);
    }

    public static final Parcelable.Creator<Animal> CREATOR = new Parcelable.Creator<Animal>() {
        // распаковываем объект из Parcel
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    // конструктор, считывающий данные из Parcel
    public Animal(Parcel parcel) {
        name = parcel.readString();
        weight = parcel.readInt();

        byte[] b = parcel.createByteArray();
        picture = new BitmapDrawable(BitmapFactory.decodeByteArray(b, 0, b.length));
    }
}
