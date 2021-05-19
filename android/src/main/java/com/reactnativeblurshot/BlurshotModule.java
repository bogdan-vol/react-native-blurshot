package com.reactnativeblurshot;

import android.graphics.Bitmap;
import android.util.Base64;
import android.view.View;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import java.io.ByteArrayOutputStream;

@ReactModule(name = BlurshotModule.NAME)
public class BlurshotModule extends ReactContextBaseJavaModule {
  public static final String NAME = "Blurshot";
  private static ReactApplicationContext rnContext;


  public BlurshotModule(ReactApplicationContext reactContext) {
    super(reactContext);
    rnContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void screenshot(Promise promise) {
    try {
      View view = rnContext.getCurrentActivity().getWindow().getDecorView().findViewById(android.R.id.content);
      view.setDrawingCacheEnabled(true);
      Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache());
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      bitmap.compress(Bitmap.CompressFormat.PNG, 10, byteArrayOutputStream);
      byte[] byteArray = byteArrayOutputStream.toByteArray();
      promise.resolve(Base64.encodeToString(byteArray, Base64.DEFAULT));
    } catch (Exception e) {
      promise.resolve("");
    }
  }
}
