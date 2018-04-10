package org.thoughtcrime.securesms.push;

import android.content.Context;
import java.io.InputStream;
import org.thoughtcrime.securesms.R;
import org.whispersystems.signalservice.api.push.TrustStore;

public class DomainFrontingTrustStore implements TrustStore {

  private final Context context;

  public DomainFrontingTrustStore(Context context) {
    this.context = context.getApplicationContext();
  }

  @Override
  public InputStream getKeyStoreInputStream() {
    return context.getResources().openRawResource(R.raw.censorship_fronting);
  }

  @Override
  public String getKeyStorePassword() {
    return "whisper";
  }
}
