
package rana.jatin.androiddevhelper.etc;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import rana.jatin.androiddevhelper.R;


public class PicassoHelper {

    private PicassoHelper instance;
    private Picasso picasso;
    private Context context;

    public PicassoHelper(Context context) {
        picasso = Picasso.with(context);
    }

    public RequestCreator load(String url, @DimenRes int resizePx) {
        Uri uri = Uri.parse(url);
        return load(uri, resizePx);
    }

    public RequestCreator load(String url) {
        if (url == null || TextUtils.isEmpty(url))
            return picasso.load(R.color.placeholder);
        return picasso.load(url);
    }

    public RequestCreator load(Uri uri, @DimenRes int resizePx) {
        int px = context.getResources().getDimensionPixelSize(resizePx);
        uri = uri.buildUpon().appendQueryParameter("width", String.valueOf(px)).build();
        return load(uri);
    }

    public RequestCreator loadWithPlaceholder(String url, @DrawableRes int placeholder) {
        return load(url).placeholder(placeholder);
    }

    public RequestCreator loadWithPlaceholder(Uri uri, @DimenRes int resizePx, @DrawableRes int placeholder) {
        int px = context.getResources().getDimensionPixelSize(resizePx);
        uri = uri.buildUpon().appendQueryParameter("width", String.valueOf(px)).build();
        return load(uri).placeholder(placeholder);
    }

    public RequestCreator load(Uri uri) {
        if (uri == null || uri.toString().isEmpty())
            return picasso.load(R.color.placeholder);
        return picasso.load(uri);
    }
}