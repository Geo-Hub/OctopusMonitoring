package org.blueventures.octopusmonitoring.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;


public class ProgressSpinner extends ProgressBar {

  public ProgressSpinner(Context context) {
    super(context);
    init();
  }

  public ProgressSpinner(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public ProgressSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }

  private void init() {
    setIndeterminate(true);
    getIndeterminateDrawable().setColorFilter(0x99ffffff, android.graphics.PorterDuff.Mode.MULTIPLY);
  }

  @Override
  protected void onVisibilityChanged(View changedView, int visibility) {
    if (visibility == INVISIBLE || visibility == GONE) {

    }
    super.onVisibilityChanged(changedView, visibility);
  }
}