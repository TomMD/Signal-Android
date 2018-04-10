package org.thoughtcrime.securesms.giph.ui;

import android.os.Bundle;
import android.support.v4.content.Loader;
import java.util.List;
import org.thoughtcrime.securesms.giph.model.GiphyImage;
import org.thoughtcrime.securesms.giph.net.GiphyGifLoader;

public class GiphyGifFragment extends GiphyFragment {

  @Override
  public Loader<List<GiphyImage>> onCreateLoader(int id, Bundle args) {
    return new GiphyGifLoader(getActivity(), searchString);
  }
}
