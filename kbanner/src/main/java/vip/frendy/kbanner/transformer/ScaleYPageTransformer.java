package vip.frendy.kbanner.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

public class ScaleYPageTransformer extends BGAPageTransformer {
    private float mMinScale = 0.9f;

    public ScaleYPageTransformer() {
    }

    public ScaleYPageTransformer(float minScale) {
        setMinScale(minScale);
    }

    @Override
    public void handleInvisiblePage(View view, float position) {
        view.setScaleY(mMinScale);
    }

    @Override
    public void handleLeftPage(View view, float position) {
        view.setScaleY(mMinScale);
    }

    @Override
    public void handleRightPage(View view, float position) {
        float scale = Math.max(mMinScale, 1 - Math.abs(position));
        view.setScaleY(scale);
    }

    public void setMinScale(float minScale) {
        if (minScale >= 0.0f && minScale <= 1.0f) {
            mMinScale = minScale;
        }
    }
}